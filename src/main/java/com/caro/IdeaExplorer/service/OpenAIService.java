package com.caro.IdeaExplorer.service;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    private static final Logger logger = LoggerFactory.getLogger(ThreadService.class);
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/engines/davinci-codex/completions";


    public String getResponse(String prompt) throws IOException {
        logger.info("api: " + apiKey);
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(OPENAI_API_URL);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + apiKey);

            String json = "{ \"prompt\": \"" + prompt + "\", \"max_tokens\": 100 }";
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                return EntityUtils.toString(response.getEntity());
            }
      }
catch (Exception e) {
        logger.error("Error while calling OpenAI API", e);
        }
            return "Error while calling OpenAI API";
    }
    }
