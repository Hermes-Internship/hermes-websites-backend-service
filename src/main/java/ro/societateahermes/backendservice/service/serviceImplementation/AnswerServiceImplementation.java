package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.repository.AnswerRepositoryInterface;
import ro.societateahermes.backendservice.service.AnswerServiceInterface;

@Service
public class AnswerServiceImplementation implements AnswerServiceInterface {

    private final AnswerRepositoryInterface answerRepository;

    public AnswerServiceImplementation(AnswerRepositoryInterface answerRepository) {
        this.answerRepository = answerRepository;
    }
}
