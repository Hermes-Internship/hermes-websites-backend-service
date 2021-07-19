package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.entities.form.Form;
import ro.societateahermes.backendservice.service.serviceImplementation.FormService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/form")
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public List<FormDto> getAll() {
        List<Form> forms = formService.getAll();
        return forms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void save(@RequestBody FormDto formDto) {
        formService.save(this.convertToEntity(formDto));
    }

    @DeleteMapping("/{formId}")
    public void delete(@PathVariable("formId") Long formId) {
        formService.delete(formId);
    }

    private FormDto convertToDto(Form form) {
        FormDto formDto = new FormDto();
        formDto.setId(form.getId());
        formDto.setQuestions(form.getQuestions());

        return formDto;
    }

    private Form convertToEntity(FormDto formDto) {
        Form form = new Form();
        form.setId(formDto.getId());
        form.setQuestions(formDto.getQuestions());

        return form;
    }
}
