package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.controller.CDMemberControllerInterface;
import ro.societateahermes.backendservice.entities.dto.CDMemberDTO;
import ro.societateahermes.backendservice.service.CDMemberServiceInterface;
import ro.societateahermes.backendservice.service.serviceImplementation.CDMemberServiceImplementation;
import ro.societateahermes.backendservice.utils.mapper.CDMemberMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cd-member")
public class CDMemberControllerImplementation implements CDMemberControllerInterface {
    private final CDMemberServiceInterface cdMemberService;

    public CDMemberControllerImplementation(CDMemberServiceImplementation cdMemberService) {
        this.cdMemberService = cdMemberService;
    }

    @PostMapping
    public ResponseEntity<String> saveCDMember(@Valid @RequestBody CDMemberDTO cdMemberDTO) {
        if (cdMemberService.isValidCdMember(cdMemberDTO)) {
            cdMemberService.save(CDMemberMapper.cdMemberDTOToCDMember(cdMemberDTO));
            return new ResponseEntity<>("", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Invalid cd member.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Override
    public List<CDMemberDTO> getAllCDMembers() {
        return cdMemberService.getAllCDMembers().stream()
                .map(CDMemberMapper::cdMemberToCDMemberDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{cd-id}")
    @Override
    public void deleteCDMember(@PathVariable("cd-id") Long cdMemberID) {
        cdMemberService.delete(cdMemberID);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    @Override
    public void updateCDMember(@Valid @RequestBody CDMemberDTO cdMemberDTO) {
        cdMemberService.update(CDMemberMapper.cdMemberDTOToCDMember(cdMemberDTO));
    }
}
