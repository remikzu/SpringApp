package pl.sda.taskmanager.service;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.taskmanager.model.Project;
import pl.sda.taskmanager.model.dto.ProjectDto;
import pl.sda.taskmanager.repository.ProjectRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Remigiusz Zudzin
 */
@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(ProjectDto project) {
        Project registered_project =
                new Project(
                        project.getAcronim(),
                        project.getDescription(),
                        project.getDateStart(),
                        project.getDateStop());
        return projectRepository.save(registered_project);
    }


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id, LocalDate dateStop) {
        Optional<Project> projectToUpdate = projectRepository.findById(id);
        if (projectToUpdate.isPresent()) {
            Project project = projectToUpdate.get();
            project.setDateStop(dateStop);
            return projectRepository.save(project);
        }
        return new Project();
    }
}
