package ro.societateahermes.backendservice.service.serviceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.entities.dto.MySubmissionDTO;
import ro.societateahermes.backendservice.entities.form.Form;
import ro.societateahermes.backendservice.entities.form.Submission;
import ro.societateahermes.backendservice.repository.FormRepository;
import ro.societateahermes.backendservice.repository.SubmissionRepositoryInterface;
import ro.societateahermes.backendservice.service.SubmissionServiceInterface;

@Service
public class SubmissionServiceImplementation implements SubmissionServiceInterface {

    @Autowired
    private SubmissionRepositoryInterface submitionRepository;

    @Autowired
    private FormRepository formRepository;


    @Override
    public void savefromDTO(MySubmissionDTO submissionDTO) {

        Form form=formRepository.getOne(submissionDTO.getFormId());
        Submission submission =new Submission();
        submission.setForm(form);
        submission.setAnswers(submissionDTO.getAnswers());
        submitionRepository.save(submission);
    }
}
