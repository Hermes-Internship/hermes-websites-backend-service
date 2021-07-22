package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.societateahermes.backendservice.entities.Event;
import ro.societateahermes.backendservice.entities.PurchasedPackage;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SponsorDTO {

    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String logo;

    @NotBlank(message = "Package is mandatory")
    private PurchasedPackage purchasedPackage;

    @NotBlank(message = "EventId is mandatory")
    private long eventId;
}
