package pl.sda.taskmanager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Remigiusz Zudzin
 */

@Data
@AllArgsConstructor
public class UserDto {

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

}
