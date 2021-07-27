package ro.societateahermes.backendservice.controller.controllerImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.Sponsor;
import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.entities.dto.SponsorDTO;
import ro.societateahermes.backendservice.entities.dto.UserDTO;
import ro.societateahermes.backendservice.service.SponsorServiceInterface;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorServiceInterface sponsorService;

    @GetMapping
    public List<SponsorDTO> getAll() {
        return sponsorService.getAll();
    }

    @GetMapping("/{sponsorId}")
    public SponsorDTO getOne(@PathVariable("sponsorId") long sponsorId) {

        return sponsorService.getOne(sponsorId);
    }

    @PostMapping
    public void save(@RequestBody @Valid SponsorDTO sponsorDTO) {
        sponsorService.save(sponsorDTO);
    }

    @DeleteMapping("/{sponsorId}")
    public void delete(@PathVariable("sponsorId") long sponsorId) {
        sponsorService.delete(sponsorId);
    }

    @PutMapping
    public void update(@RequestBody @Valid SponsorDTO sponsorDTO)
    {
        sponsorService.update(sponsorDTO);
    }


}
