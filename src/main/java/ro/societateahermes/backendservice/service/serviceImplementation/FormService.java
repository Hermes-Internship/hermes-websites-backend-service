package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.form.Form;
import ro.societateahermes.backendservice.entities.form.Question;
import ro.societateahermes.backendservice.repository.FormRepository;
import ro.societateahermes.backendservice.repository.QuestionRepository;

import java.util.List;

@Service
public class FormService {
    private final FormRepository formRepository;
    private final QuestionRepository questionRepository;

    public FormService(FormRepository formRepository, QuestionRepository questionRepository) {
        this.formRepository = formRepository;
        this.questionRepository = questionRepository;
    }

    public List<Form> getAll() {
        return formRepository.findAll();
    }

    public void save(Form form) {
        for (Question question : form.getQuestions()) {
            questionRepository.save(question);
        }

        formRepository.save(form);
    }
}