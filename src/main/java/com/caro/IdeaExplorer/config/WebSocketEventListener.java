package com.caro.IdeaExplorer.config;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.entity.Content;
import com.caro.IdeaExplorer.entity.ContentType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(
           SessionDisconnectEvent event
    ) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String authorName = (String)headerAccessor.getSessionAttributes().get("authorName");
        if(authorName != null){
            log.info("User disconnected: {}", authorName);
            var chatMessage = Content.builder()
                    .type(ContentType.LEAVE)
                    .author(new Author(1, authorName))
                    .build();
            messageTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}


