package pl.sda.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Remigiusz Zudzin
 */

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    //dane wprowadzone przez użytkownika
    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @Email
    @NotBlank
    private String email;

    @Size(min = 6)
//    @Pattern(regexp = "[A-Z0-9#-]{1,}")
    @NotBlank
    private String password;

    //dane generoowane automatycznie
    private LocalDateTime registration_datetime = LocalDateTime.now();

    // relacja m:m user to role
    @ManyToMany
    @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    //metoda dodawania roli
    public void addRole(Role role) {
        this.roles.add(role);
    }

    public User(@NotBlank String name,
                @NotBlank String lastname,
                @Email @NotBlank String email,
                @Size(min = 6)
                @Pattern(regexp = "[A-Z0-9#-]{1,}")
                @NotBlank String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}
