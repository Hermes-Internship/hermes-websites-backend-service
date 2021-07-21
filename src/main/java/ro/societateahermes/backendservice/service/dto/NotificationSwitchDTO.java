package ro.societateahermes.backendservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSwitchDTO {
    private String message;
    private Boolean isInProgress;

}
