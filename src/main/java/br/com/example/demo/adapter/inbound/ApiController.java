package br.com.example.demo.adapter.inbound;

import br.com.example.demo.application.usecase.CreateObjectUseCase;
import br.com.example.demo.application.usecase.GetObjectsUseCase;
import br.com.example.demo.domain.ObjectPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final GetObjectsUseCase getObjectsUseCase;
    private final CreateObjectUseCase createObjectUseCase;

    @Autowired
    public ApiController(GetObjectsUseCase getObjectsUseCase, CreateObjectUseCase createObjectUseCase) {
        this.getObjectsUseCase = getObjectsUseCase;
        this.createObjectUseCase = createObjectUseCase;
    }

    @GetMapping("/objects")
    public Object getObjects() {
        return getObjectsUseCase.getObjects();
    }

    @PostMapping("/objects")
    public Object createObject(@RequestBody ObjectPayload objectPayload) {
        return createObjectUseCase.createObject(objectPayload);
    }
}
