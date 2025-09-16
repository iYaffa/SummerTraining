package com.example.telegram_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@RestController
public class MessageController {

    private final SilentSender silentSender;

    @Autowired
    public MessageController(SimpleBot simpleBot) {
        this.silentSender = simpleBot.getSilentSender();
    }

    @PostMapping("/send-message")
    public String sendMessage(@RequestParam("chatId") String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("hello");
        silentSender.execute(message);
        return "Hello message sent to chat ID: " + chatId;
    }
}