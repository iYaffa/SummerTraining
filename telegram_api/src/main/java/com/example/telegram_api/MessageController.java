package com.example.telegram_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/send-message/{chatID}/{message}")
    public String sendMessage(@PathVariable("message") String msg, @PathVariable("chatID") String chatID) {
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(msg);
        silentSender.execute(message);
        return "Message sent to chat ID: " + chatID;
    }
}