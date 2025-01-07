package br.com.example.demo.adapter.outbound;

import br.com.example.demo.domain.ObjectPayload;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalApiClient {

    private final RestTemplate restTemplate;

    public ExternalApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getObjectsFromApi() {
        String url = "https://api.restful-api.dev/objects";
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return response.getBody();
    }

    // Method for the API when name starts with "Ap"
    public Object createObjectForAp(ObjectPayload objectPayload) {
        String url = "https://dogapi.dog/docs/api-v2/facts"; // Replace with actual API URL for "Ap"

        return sendtRequest(url, objectPayload);
    }

    // Method for the fallback API
    public Object createObjectForNonAp(ObjectPayload objectPayload) {
        String url = "https://api.placeholder.com/non-ap"; // Replace with actual API URL for non-"Ap"

        return sendPostRequest(url, objectPayload);
    }

    // Helper method to send POST request to external API
    private Object sendPostRequest(String url, ObjectPayload objectPayload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ObjectPayload> request = new HttpEntity<>(objectPayload, headers);

        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
        return response.getBody();
    }
}
