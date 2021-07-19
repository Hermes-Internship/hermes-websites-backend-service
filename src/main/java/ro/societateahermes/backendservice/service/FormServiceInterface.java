package ro.societateahermes.backendservice.service;

import ro.societateahermes.backendservice.entities.form.Form;

import java.util.List;

public interface FormServiceInterface {
    List<Form> getAll();

    void save(Form form);

    void delete(Long formId);
}
