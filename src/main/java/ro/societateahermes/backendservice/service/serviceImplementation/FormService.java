package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.form.Form;
import ro.societateahermes.backendservice.entities.form.Option;
import ro.societateahermes.backendservice.entities.form.Question;
import ro.societateahermes.backendservice.repository.FormRepository;

import java.util.List;

@Service
public class FormService {
    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public List<Form> getAll() {
        return formRepository.findAll();
    }

    public void save(Form form) {
        for (Question question : form.getQuestions()) {
            question.setForm(form);

            for (Option option : question.getOptions()) {
                option.setQuestion(question);
            }
        }

        formRepository.save(form);
    }

    public void delete(Long formId) {
        formRepository.delete(formRepository.findById(formId).get());
    }
}
