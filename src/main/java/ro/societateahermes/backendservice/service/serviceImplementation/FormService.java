package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.entities.form.Form;
import ro.societateahermes.backendservice.entities.form.Option;
import ro.societateahermes.backendservice.entities.form.Question;
import ro.societateahermes.backendservice.repository.FormRepository;
import ro.societateahermes.backendservice.service.FormServiceInterface;
import ro.societateahermes.backendservice.utils.mapper.FormMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormService implements FormServiceInterface {
    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public List<FormDto> getAll() {
        List<Form> forms = formRepository.findAll();
        return forms.stream()
                .map(FormMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public void save(FormDto formDto) {
        Form form = FormMapper.convertToEntity(formDto);
        for (Question question : form.getQuestions()) {
            question.setForm(form);

            for (Option option : question.getOptions()) {
                option.setQuestion(question);
            }
        }

        formRepository.save(form);
    }

    public void delete(Long formId) {
        formRepository.delete(formRepository.findById(formId).orElseThrow());
    }
}
