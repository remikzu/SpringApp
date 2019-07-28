package pl.sda.taskmanager.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.sda.taskmanager.model.Project;
import pl.sda.taskmanager.model.User;
import pl.sda.taskmanager.model.dto.ProjectDto;
import pl.sda.taskmanager.repository.ProjectRepository;
import pl.sda.taskmanager.service.ProjectService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Remigiusz Zudzin
 */

@RestController
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
    }

    @PostMapping("/project/{acronim}&{description}&{dateStart}&{dateStop}")
    public Project addProject(
            @PathVariable String acronim,
            @PathVariable String description,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStop
    ) {
        return projectService.addProject(new ProjectDto(acronim, description, dateStart, dateStop));
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping("/project/{id}/change/{newDateStop}")
    public Project changeDateStop(
            @PathVariable Long id,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate newDateStop
    ) {
        return projectService.getProjectById(id, newDateStop);
    }

}
