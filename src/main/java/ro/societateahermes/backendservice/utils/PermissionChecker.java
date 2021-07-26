package ro.societateahermes.backendservice.utils;

import ro.societateahermes.backendservice.entities.ERole;
import ro.societateahermes.backendservice.entities.Role;

import java.util.List;

public class PermissionChecker {

    public static boolean check(String event, List<String> roles) {
        switch (event.toLowerCase()) {
            case "cariereinit":
                return roles.contains("ROLE_ADMIN") || roles.contains("ROLE_PROJECT_MANAGER_CARIEREIT");

            default: return false;
        }
    }

}
