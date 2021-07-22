package ro.societateahermes.backendservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.societateahermes.backendservice.entities.PurchasedPackage;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SponsorDTO {

    private long id;
    private String name;
    private String logo;
    private PurchasedPackage purchasedPackage;
    private long eventId;
}