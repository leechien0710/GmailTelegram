package com.example.springmail;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
@Service
public class TelegramService extends TelegramLongPollingBot {
    private static final String token = "7173659220:AAFmntHZMZjz-VbwSAKojqkjwUfJcCUJJ4Q";
    private static final String username = "chienmailbot";
    private static final String chatId = "-1002101694241";


    /**
     * @param update
     */
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("time");
        if (update.getMessage() != null && update.getMessage().getNewChatMembers() != null) {
            update.getMessage().getNewChatMembers().forEach(user -> {
                if (user.getUserName().equals(username)) {
                    long chatId = update.getMessage().getChatId();
                    SendMessage message = new SendMessage();
                    message.setChatId(chatId);
                    message.setText("This group chat ID is " + chatId);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    public String getBotUsername() {
        return "chienmailbot";
    }


    public String getBotToken() {
        return "7173659220:AAFmntHZMZjz-VbwSAKojqkjwUfJcCUJJ4Q";
    }
    public void sendMail(String mes,String chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(mes);

        try {
            this.execute(sendMessage);
        } catch (TelegramApiException var4) {
            var4.printStackTrace();
        }

    }
}


