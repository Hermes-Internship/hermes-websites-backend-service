package ro.societateahermes.backendservice.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.societateahermes.backendservice.repository.SponsorRepositoryInterface;
import ro.societateahermes.backendservice.service.SponsorServiceInterface;


@Service
public class SponsorServiceImplementation implements SponsorServiceInterface {

    @Autowired
    private SponsorRepositoryInterface sponsorRepository;


}
