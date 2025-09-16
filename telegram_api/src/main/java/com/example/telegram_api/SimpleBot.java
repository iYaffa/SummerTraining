
package com.example.telegram_api;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
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
                    message.setText("Hello, your chat id is: " + ctx.chatId()
                            + " if you want to test the bot using url");
                    silent.execute(message);
                    System.out.println("\n **************************************" + "CHAT ID IS " + ctx.chatId()
                            + "\n **************************************");
                })
                .build();
    }

    @Override
    public long creatorId() {
        return 1L;

    }
}