package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.form.Form;
import ro.societateahermes.backendservice.service.serviceImplementation.FormService;

import java.util.List;

@RestController
@RequestMapping("/form")
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public List<Form> getAll() {
        return formService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Form form) {
        formService.save(form);
    }
}
