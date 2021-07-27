package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.dto.FormDto;
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
    public List<FormDto> getAll() {
        return formService.getAll();
    }

    @GetMapping("/{eventId}")
    public FormDto getForm(@PathVariable Long eventId) {
        return formService.getForm(eventId);
    }

    @PostMapping("/{eventId}")
    public void save(@PathVariable Long eventId,
                     @RequestBody FormDto formDto) {
        formService.save(eventId, formDto);
    }

    @DeleteMapping("/{formId}")
    public void delete(@PathVariable("formId") Long formId) {
        formService.delete(formId);
    }
}
