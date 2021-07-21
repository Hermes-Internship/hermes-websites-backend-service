package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.dto.FormDto;

import java.util.List;

public interface FormServiceInterface {
    List<FormDto> getAll();

    void save(FormDto formDto);

    void delete(Long formId);
}
