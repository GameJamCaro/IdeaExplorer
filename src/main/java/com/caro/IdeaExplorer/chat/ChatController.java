package com.caro.IdeaExplorer.chat;

import com.caro.IdeaExplorer.entity.Content;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Content sendMessage(@Payload Content message) {

        return message;
    }

    @MessageMapping("/chat.addAuthor")
    @SendTo("/topic/public")
    public Content addAuthor(@Payload Content message, SimpMessageHeaderAccessor headerAccessor) {
        // add username to web socket session
        headerAccessor.getSessionAttributes().put("authorName", message.getAuthor());
        return message;
    }
}