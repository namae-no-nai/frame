package br.com.example.demo.application.usecase;

import br.com.example.demo.adapter.outbound.ExternalApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetObjectsUseCase {

    private final ExternalApiClient externalApiClient;

    @Autowired
    public GetObjectsUseCase(ExternalApiClient externalApiClient) {
        this.externalApiClient = externalApiClient;
    }

    public Object getObjects() {
        return externalApiClient.getObjectsFromApi();
    }
}
