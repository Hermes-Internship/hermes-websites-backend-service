package ro.societateahermes.backendservice.utils;


import java.util.List;

public class PermissionChecker {


    public static final String EVENT_A = "destresiune";
    public static final String EVENT_B = "cariereinit";
    public static final String EVENT_C = "guideDays";
    public static final String EVENT_D = "hackathon";


    public static boolean check(String event, List<String> roles) {
        switch (event.toLowerCase()) {
            case EVENT_A:
                return roles.contains("ROLE_ADMIN") || roles.contains("ROLE_PROJECT_MANAGER_DESTRESIUNE");
            case EVENT_B:
                return roles.contains("ROLE_ADMIN") || roles.contains("ROLE_PROJECT_MANAGER_CARIEREIT");
            case EVENT_C:
                return roles.contains("ROLE_ADMIN") || roles.contains("ROLE_PROJECT_MANAGER_GUIDEDAYS");
            case EVENT_D:
                return roles.contains("ROLE_ADMIN") || roles.contains("ROLE_PROJECT_MANAGER_HACKATHON");
            default:
                return false;
        }
    }

}
