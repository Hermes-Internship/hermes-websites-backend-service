package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ro.societateahermes.backendservice.controller.CDMemberControllerInterface;
import ro.societateahermes.backendservice.entities.CDMember;
import ro.societateahermes.backendservice.entities.DTO.CDMemberDTO;
import ro.societateahermes.backendservice.service.serviceImplementation.CDMemberServiceImplementation;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cdMember")
public class CDMemberControllerImplementation implements CDMemberControllerInterface {
    private final CDMemberServiceImplementation CDMemberService;

    public CDMemberControllerImplementation(CDMemberServiceImplementation serviceImplementation) {
        CDMemberService = serviceImplementation;
    }

    @PostMapping("/CD")
    @ResponseStatus(HttpStatus.CREATED)
    public CDMember saveCDMember(@Valid @RequestBody CDMember CDMember) {
        return CDMemberService.save(CDMember);
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
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public CDMember updateCDMember(@PathVariable("cdID") Long CDMemberID, @Valid @RequestBody CDMemberDTO cdMemberDTO) {
        return CDMemberService.update(CDMemberID, cdMemberDTO);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
