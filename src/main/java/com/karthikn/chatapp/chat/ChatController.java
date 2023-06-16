package com.karthikn.chatapp.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    //send message --> if any user join to the chat
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
           @Payload ChatMessage chatMessage //for websocket
    ){
        return chatMessage;
    }

    //add the user method and add the user to the websocker session

    @MessageMapping("/chat.add")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ){

        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;
    }
}
