
package com.example.springmail;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SendEmailController {
    private static final String APPLICATION_NAME = "GmailAlexa";
    private static HttpTransport httpTransport;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static Gmail client;
    GoogleClientSecrets clientSecrets;
    GoogleAuthorizationCodeFlow flow;
    private String clientId ="733009833974-m6ttpe8r9uih2qu3g1la021rqrc4f1ju.apps.googleusercontent.com";
    private String clientSecret = "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";
    private String redirectUri = "http://localhost:8080/Callback";
    private String oauth2CallbackCode;
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private Credential credential;
    private long timebefore = 0L;
    TokenResponse response;
    @Autowired
    TelegramService telegramService;

    public SendEmailController() {
    }

    @RequestMapping(
        value = {"/"},
        method = {RequestMethod.GET}
    )
    public RedirectView googleConnectionStatus(HttpServletRequest request) throws Exception {
        return new RedirectView(this.authorize());
    }

    @RequestMapping(
        value = {"/Callback"},
        method = {RequestMethod.GET},
        params = {"code"}
    )
    public RedirectView oauth2Callback(@RequestParam("code") String code) throws GeneralSecurityException, IOException {
        this.oauth2CallbackCode = code;
        this.response = this.flow.newTokenRequest(this.oauth2CallbackCode).setRedirectUri(this.redirectUri).execute();
        System.out.println("token response: " + String.valueOf(this.response));
        if (this.credential == null) {
            this.credential = this.flow.createAndStoreCredential(this.response, "userID");
            System.out.println("cre :" + String.valueOf(this.credential));
        }

        System.out.println("credential: " + this.credential.toString());
        return new RedirectView("/home");
    }

    private String authorize() throws Exception {
        if (this.flow == null) {
            GoogleClientSecrets.Details web = new GoogleClientSecrets.Details();
            web.setClientId(this.clientId);
            web.setClientSecret(this.clientSecret);
            this.clientSecrets = (new GoogleClientSecrets()).setWeb(web);
            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            this.flow = (new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, this.clientSecrets, Collections.singleton("https://www.googleapis.com/auth/gmail.readonly"))).setDataStoreFactory(new FileDataStoreFactory(new File("tokens"))).setAccessType("offline").build();
        }

        AuthorizationCodeRequestUrl authorizationUrl = this.flow.newAuthorizationUrl().setRedirectUri(this.redirectUri);
        System.out.println("gamil authorizationUrl ->" + String.valueOf(authorizationUrl));
        return authorizationUrl.build();
    }

    @GetMapping({"/home"})
    private ResponseEntity<?> oauth2CallbackLogic() throws GeneralSecurityException, IOException {
        String body = "";

        try {
            client = (new Gmail.Builder(httpTransport, JSON_FACTORY, this.credential)).setApplicationName("GmailAlexa").build();
            String userId = "me";
            String query = "subject:'Welcome to A2Cart'";
            List<Message> messages = ((ListMessagesResponse)client.users().messages().list(userId).setMaxResults(1L).execute()).getMessages();
            System.out.println("es" + String.valueOf(messages));
            Iterator var5 = messages.iterator();

            label49:
            while(true) {
                while(true) {
                    Message detailedMessage;
                    do {
                        if (!var5.hasNext()) {
                            break label49;
                        }

                        Message message = (Message)var5.next();
                        String messageId = message.getId();
                        detailedMessage = (Message)client.users().messages().get(userId, messageId).execute();
                        long time = detailedMessage.getInternalDate();
                        System.out.println("time: " + time);
                        Date sentDate = new Date(time);
                        System.out.println("sentDate" + String.valueOf(sentDate));
                        if (time == this.timebefore) {
                            return ResponseEntity.ok("Trùng với cái trước");
                        }

                        this.timebefore = time;
                    } while(detailedMessage.getPayload().getParts() == null);

                    Iterator var12 = detailedMessage.getPayload().getParts().iterator();

                    while(var12.hasNext()) {
                        MessagePart part = (MessagePart)var12.next();
                        if (part.getMimeType().equals("text/plain")) {
                            byte[] decodedBytes = Base64.decodeBase64(part.getBody().getData());
                            body = new String(decodedBytes);
                            break;
                        }
                    }
                }
            }
        } catch (Exception var15) {
            System.out.println("exception cached ");
            var15.printStackTrace();
        }

        System.out.println("body: " + body);
        int startIndex = body.indexOf("Số dư mới của tài khoản trên là");
        int endIndex = body.indexOf("Cảm ơn Quý khách hàng đã sử dụng Sản phẩm/ Dịch vụ của ACB");
        if (startIndex != -1 && endIndex != -1) {
            String transactionInfo = body.substring(startIndex, endIndex);
            System.out.println("Thông tin về số dư và giao dịch:");
            System.out.println(transactionInfo);
            this.telegramService.sendMail(transactionInfo);
        } else {
            System.out.println("Không tìm thấy thông tin về số dư và giao dịch trong văn bản.");
        }

        return new ResponseEntity(body, HttpStatus.OK);
    }

    @Scheduled(
        fixedDelay = 2000L
    )
    public void scheduledOauth2Callback() throws GeneralSecurityException, IOException {
        System.out.println("access");
        if (this.credential != null) {
            this.oauth2CallbackLogic();
            this.oauth2CallbackCode = null;
        }

    }
}
