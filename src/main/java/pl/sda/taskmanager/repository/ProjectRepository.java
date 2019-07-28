package pl.sda.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.taskmanager.model.Project;

/**
 * @author Remigiusz Zudzin
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
