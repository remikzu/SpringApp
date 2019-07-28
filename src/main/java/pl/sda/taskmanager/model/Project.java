package pl.sda.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Remigiusz Zudzin
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;

    @NotBlank
    private String acronim;

    @NotBlank
    @Column(columnDefinition = "text")
    private String description;

    @NotNull
    private LocalDate dateStart;

    @NotNull
    private LocalDate dateStop;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();

    public Project(@NotBlank String acronim, @NotBlank String description, @NotBlank LocalDate dateStart, @NotBlank LocalDate dateStop) {
        this.acronim = acronim;
        this.description = description;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
    }
}
