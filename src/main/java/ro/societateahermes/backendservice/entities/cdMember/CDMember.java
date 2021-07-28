package ro.societateahermes.backendservice.entities.cdMember;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CDMember {
    @Id
    @GeneratedValue
    private Long CDMemberID;
    private String imagePath;
    private String facebookLink;
    private String description;
    private String name;
    private String position;

    private Integer departmentId;

    private Integer roleId;

    public Department getDepartmentType() {
        return Department.getDepartmentType(departmentId);
    }

    public String getDepartmentName() {
        return Department.getDepartmentType(departmentId).getName();
    }

    public Role getRoleType() {
        return Role.getRoleType(roleId);
    }

    public String getRoleName() {
        return Role.getRoleType(roleId).getName();
    }
}
