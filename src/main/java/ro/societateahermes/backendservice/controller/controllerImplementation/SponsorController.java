package ro.societateahermes.backendservice.controller.controllerImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.societateahermes.backendservice.service.SponsorServiceInterface;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorServiceInterface sponsorService;


}
