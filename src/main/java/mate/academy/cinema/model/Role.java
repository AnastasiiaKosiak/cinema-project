package mate.academy.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private RoleName roleName;
     
    public Role() {
    }
   
    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
   
    public static Role of(String roleName) {
        return new Role(RoleName.valueOf(roleName));
    }
   
    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }
  
    public RoleName getRoleName() {
        return roleName;
    }
  
    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public enum RoleName {
        ADMIN, USER;
    }
}
