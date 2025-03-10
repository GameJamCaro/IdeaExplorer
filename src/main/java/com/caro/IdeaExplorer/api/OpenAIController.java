package com.caro.IdeaExplorer.api;

import com.caro.IdeaExplorer.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OpenAIController {

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/openai")
    public String getOpenAIResponse(@RequestParam String prompt) throws IOException {
        return openAIService.getResponse(prompt);
    }
}