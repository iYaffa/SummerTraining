This is a project for trying to integrate telegram API with a spring boot application.

The steps of how this was done:
1. Creating the bot:

    a. I created the bot by searching for @BotFather on telegram
   
    b. I asked it to create a new bot by sending /newbot
  
    c. it generated the botToken after I gave a username for it.
    
    d. The BotToken is used later when connecting to it
3. implementing the bot:
   
    a. I added the telegram dependencies in the pom.xml file.

    b. implementing the bot class that extends the ability bot (the core)

    c. customized how it will respond to "/start" message.

    d. the chat id is then given so it's used later on.

5. The bot's response: when the user sends a /start message to the bot (Link: t.me/CaramelSpring_bot) the bot responds with a message

6. For making the bot send a message, using post man: 

    a. ChatId is required for this step so you have to send it a /start message first to get the chatID, then the chatid is printed on the terminal console. 

    b. to send a message, open postman and send a post request to: http://localhost:8080/send-message/{CHAT_ID}/{THE_MESSAGE_YOU_WANT_TO_SEND}
