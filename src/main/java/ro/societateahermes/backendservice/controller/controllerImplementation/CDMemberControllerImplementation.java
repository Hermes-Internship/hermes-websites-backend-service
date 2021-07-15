package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.web.bind.annotation.*;

import ro.societateahermes.backendservice.controller.CDMemberControllerInterface;
import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;
import ro.societateahermes.backendservice.service.serviceImplementation.CDMemberServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/cdMember")
public class CDMemberControllerImplementation implements CDMemberControllerInterface {
    private final CDMemberServiceImplementation CDMemberService;

    public CDMemberControllerImplementation(CDMemberServiceImplementation serviceImplementation) {
        CDMemberService = serviceImplementation;
    }

    @PostMapping
    @Override
    public void saveCDMember(@RequestBody CDMember CDMember) {
        CDMemberService.save(CDMember);

    }

    @GetMapping
    @Override
    public List<CDMember> getAllCDMembers() {
        return CDMemberService.getAllCDMembers();
    }

    @DeleteMapping("/{CDMemberID}")
    @Override
    public void deleteCDMember(@PathVariable("CDMemberID") Long CDMemberID) {
        CDMemberService.delete(CDMemberID);
    }

    @PutMapping("/{cdID}")
    @Override
    public void updateCDMember(@PathVariable("cdID") Long CDMemberID, @RequestBody CDMemberDTO cdMemberDTO) {
        CDMemberService.update(CDMemberID, cdMemberDTO);
    }
}
