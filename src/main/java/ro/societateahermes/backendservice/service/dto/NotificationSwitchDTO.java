package ro.societateahermes.backendservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationSwitchDTO {
    private String message;
    private Boolean isInProgress;

}
