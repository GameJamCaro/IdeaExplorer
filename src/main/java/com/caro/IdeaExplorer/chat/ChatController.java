package com.caro.IdeaExplorer.chat;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.entity.Content;
import com.caro.IdeaExplorer.entity.Thread;
import com.caro.IdeaExplorer.repo.ThreadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ThreadRepo threadRepo;

    private Thread newThread;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Content sendMessage(@Payload Content message) {
        //add message to thread and save to database
        newThread.addContent(message);
        threadRepo.save(newThread);
        return message;
    }

    @MessageMapping("/chat.addAuthor")
    @SendTo("/topic/public")
    public Content addAuthor(@Payload Content message, SimpMessageHeaderAccessor headerAccessor) {
        // add username to web socket session
        headerAccessor.getSessionAttributes().put("authorName", message.getAuthor());

        // if current thread does not exist, create a new thread
        com.caro.IdeaExplorer.entity.Thread thread = threadRepo.findById(message.getThread().getId()).orElseGet(() ->
        {
            if(newThread == null) {
                newThread = new Thread();
            }
            newThread.setName("New Thread");
            newThread.addAuthor(message.getAuthor());
            return threadRepo.save(newThread);
        });


        message.setThread(thread);
        return message;
    }
}