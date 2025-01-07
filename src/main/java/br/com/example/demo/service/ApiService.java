package br.com.example.demo.service;

import br.com.example.demo.domain.ObjectPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getObjectsFromApi() {
        String url = "https://api.restful-api.dev/objects";
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return response.getBody();
    }

    public Object createObject(ObjectPayload objectPayload) {
        String url = "https://api.restful-api.dev/objects";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ObjectPayload> request = new HttpEntity<>(objectPayload, headers);

        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
        return response.getBody();
    }
}
