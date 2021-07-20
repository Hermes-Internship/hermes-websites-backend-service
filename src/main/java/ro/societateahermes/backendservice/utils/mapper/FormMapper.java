package ro.societateahermes.backendservice.utils.mapper;

import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.entities.form.Form;

public class FormMapper {
    public static FormDto convertToDto(Form form) {
        return new FormDto(form.getId(), form.getQuestions());
    }

    public static Form convertToForm(FormDto formDto) {
        return new Form(formDto.getId(), formDto.getQuestions());
    }
}
