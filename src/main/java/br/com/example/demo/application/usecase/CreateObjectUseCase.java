package br.com.example.demo.application.usecase;

import br.com.example.demo.domain.ObjectPayload;
import br.com.example.demo.adapter.outbound.ExternalApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateObjectUseCase {

    private final ExternalApiClient externalApiClient;

    @Autowired
    public CreateObjectUseCase(ExternalApiClient externalApiClient) {
        this.externalApiClient = externalApiClient;
    }

    public Object createObject(ObjectPayload objectPayload) {
        if (objectPayload.getName().startsWith("Ap")) {
            return externalApiClient.createObjectForAp(objectPayload);
        } else {
            return externalApiClient.createObjectForNonAp(objectPayload);
        }
    }
}
