package com.ryan.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebHookService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendData(Object payload){
        String webHookUrl = "https://webhook.site/7c3ee439-daa6-4766-94d0-088e2b3ef615";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Object> request = new HttpEntity<>(payload, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                webHookUrl,
                HttpMethod.POST,
                request,
                String.class
        );

        System.out.println("Webhook response status: " + response.getStatusCode());
        System.out.println("Webhook response body: " + response.getBody());
    }
}
