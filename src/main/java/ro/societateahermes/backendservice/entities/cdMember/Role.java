package ro.societateahermes.backendservice.entities.cdMember;

public enum Role {
    PRESIDENT(1, "PREȘEDINTE"),
    VICE_PRESIDENT(2, "VICEPREȘEDINTE"),
    MANAGER(3, "MANAGER"),
    CENSOR(4, "CENZOR"),
    SECRETARY(5, "SECRETAR"),
    AUXILIARY_IT_COORDINATOR(6, "COORDONATOR CORP AUXILIAR DE IT"),
    PROJECTS_VICE_PRESIDENT(7, "VICEPREȘEDINTE PROIECTE");

    private final int id;
    private final String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role getRoleType(Integer id) {
        if (id == null) {
            return null;
        }

        for (Role role : Role.values()) {
            if (id.equals(role.getId())) {
                return role;
            }
        }

        throw new IllegalArgumentException("No matching department type for id " + id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
