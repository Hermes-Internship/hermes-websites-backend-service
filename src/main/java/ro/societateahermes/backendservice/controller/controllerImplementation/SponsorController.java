package ro.societateahermes.backendservice.controller.controllerImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.Sponsor;
import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.entities.dto.SponsorDTO;
import ro.societateahermes.backendservice.entities.dto.UserDTO;
import ro.societateahermes.backendservice.exceptions.UnathorizeException;
import ro.societateahermes.backendservice.service.SponsorServiceInterface;
import ro.societateahermes.backendservice.utils.PermissionChecker;
import ro.societateahermes.backendservice.utils.RolesActiveUser;

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

    @PostMapping("/{event}")
    public void save(@PathVariable("event") String eventType, @RequestBody @Valid SponsorDTO sponsorDTO) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventType, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        sponsorService.save(sponsorDTO);
    }

    @DeleteMapping("/{event}/{sponsorId}")
    public void delete(@PathVariable("event") String eventType, @PathVariable("sponsorId") long sponsorId) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventType, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        sponsorService.delete(sponsorId);
    }

    @PutMapping("/{event}")
    public void update(@PathVariable("event") String eventType, @RequestBody @Valid SponsorDTO sponsorDTO) throws UnathorizeException {
        List<String> roles = RolesActiveUser.getRoles();
        if (!PermissionChecker.check(eventType, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        sponsorService.update(sponsorDTO);
    }


}
