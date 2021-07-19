package ro.societateahermes.backendservice.service.serviceImplementation;


import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.DTO.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.form.Form;
import ro.societateahermes.backendservice.entities.form.Submission;
import ro.societateahermes.backendservice.repository.FormRepository;
import ro.societateahermes.backendservice.repository.SubmissionRepositoryInterface;
import ro.societateahermes.backendservice.service.SubmissionServiceInterface;

@Service
public class SubmissionServiceImplementation implements SubmissionServiceInterface {

    private final SubmissionRepositoryInterface submitionRepository;
    private final FormRepository formRepository;

    public SubmissionServiceImplementation(SubmissionRepositoryInterface submitionRepository, FormRepository formRepo) {
        this.submitionRepository = submitionRepository;
        this.formRepository=formRepo;
    }

    @Override
    public void savefromDTO(MySubmissionDTO submissionDTO) {

        Form form=formRepository.getOne(submissionDTO.getFormId());
        Submission submission =new Submission();
        submission.setForm(form);
        submission.setAnswers(submissionDTO.getAnswers());
        submitionRepository.save(submission);
    }
}
