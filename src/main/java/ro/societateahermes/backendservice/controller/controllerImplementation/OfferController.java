package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.Offer;
import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.entities.dto.OfferDTO;
import ro.societateahermes.backendservice.exceptions.UnathorizeException;
import ro.societateahermes.backendservice.service.OfferServiceInterface;
import ro.societateahermes.backendservice.utils.PermissionChecker;
import ro.societateahermes.backendservice.utils.RolesActiveUser;

import java.util.List;

@RestController
@RequestMapping("/offer")

public class OfferController {
    private OfferServiceInterface offerService;

    @Autowired
    public OfferController(OfferServiceInterface offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public List<OfferDTO> getAll() {
        return offerService.getAll();
    }


    @PostMapping("/{event}")
    public void save(@PathVariable("event") String eventType, @RequestBody OfferDTO offerDTO) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventType, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        offerService.save(offerDTO);
    }

    @DeleteMapping("/{event}/{offerId}")
    public void delete(@PathVariable("event") String eventType, @PathVariable("offerId") Long offerId) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventType, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        offerService.delete(offerId);
    }

    @PutMapping("/{event}")
    public void update(@PathVariable("event") String eventType, @RequestBody OfferDTO offerDTO) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventType, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        offerService.update(offerDTO);
    }

    @GetMapping("/{offerId}")
    public OfferDTO getOne(@PathVariable("offerId") long offerId) {
        return offerService.getOne(offerId);
    }

    @GetMapping("/sponsor/{sponsorId}")
    public List<OfferDTO> getBySponsor(@PathVariable("sponsorId") long sponsorId) {
        return offerService.getBySponsor(sponsorId);
    }
}
