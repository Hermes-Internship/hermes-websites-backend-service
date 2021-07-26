package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.societateahermes.backendservice.entities.Admin;
import ro.societateahermes.backendservice.entities.Role;
import ro.societateahermes.backendservice.entities.dto.FormDto;
import ro.societateahermes.backendservice.exceptions.UnathorizeException;
import ro.societateahermes.backendservice.security.services.AdminDetailsImpl;
import ro.societateahermes.backendservice.service.serviceImplementation.FormService;
import ro.societateahermes.backendservice.utils.PermissionChecker;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/form")
public class FormController {

    private final FormService formService;


    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public List<FormDto> getAll() {
        return formService.getAll();
    }


    @PostMapping("/{event}")
    public void save(@PathVariable("event") String eventType, @RequestBody FormDto formDto) throws UnathorizeException {

        AdminDetailsImpl adminDetails = (AdminDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = adminDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        if (!PermissionChecker.check(eventType, roles)) {
            throw new UnathorizeException("User is not authorized");
        }
        formService.save(formDto);
    }

    @DeleteMapping("/{formId}")
    public void delete(@PathVariable("formId") Long formId) {
        formService.delete(formId);
    }
}
