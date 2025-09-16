
package com.example.telegram_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class SimpleBot extends AbilityBot {

    @Autowired
    public SimpleBot() {
        super("7899599585:AAG8JxFhOkiiJunuGNOsiJu6-mcIoovQM3U", "CaramelSpring_bot");

    }

    public SilentSender getSilentSender() {
        return silent;
    }

    @Override
    public long creatorId() {
        return 1L; // Replace with your Telegram user ID if needed
    }

    public Ability startBot() {
        return Ability
                .builder()
                .name("start")
                .info("Sends a greeting")
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {
                    SendMessage message = new SendMessage();
                    message.setChatId(ctx.chatId());
                    message.setText("hello");
                    silent.execute(message);
                })
                .build();
    }
}