package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.Offer;
import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.entities.dto.OfferDTO;
import ro.societateahermes.backendservice.service.OfferServiceInterface;

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


    @PostMapping
    public void save(@RequestBody OfferDTO offerDTO) {
        offerService.save(offerDTO);
    }

    @DeleteMapping("/{offerId}")
    public void delete(@PathVariable("offerId") Long offerId) {
        offerService.delete(offerId);
    }
}
