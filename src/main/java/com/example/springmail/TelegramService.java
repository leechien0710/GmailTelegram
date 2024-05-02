package com.example.springmail;


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

    public TelegramService() {
    }

    public void onUpdateReceived(Update update) {
    }

    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    public String getBotUsername() {
        return "chienmailbot";
    }

    public void onRegister() {
        super.onRegister();
    }

    public String getBotToken() {
        return "7173659220:AAFmntHZMZjz-VbwSAKojqkjwUfJcCUJJ4Q";
    }

    public void sendMail(String mes) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId("-1002101694241");
        sendMessage.setText(mes);

        try {
            this.execute(sendMessage);
        } catch (TelegramApiException var4) {
            var4.printStackTrace();
        }

    }
}


