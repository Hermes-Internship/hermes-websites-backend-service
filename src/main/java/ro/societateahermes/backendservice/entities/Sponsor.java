package ro.societateahermes.backendservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sponsor {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String logo;

    @Enumerated(EnumType.ORDINAL)
    private PurchasedPackage purchasedPackage;


}
