package pl.sda.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.taskmanager.model.Role;

/**
 * @author Remigiusz Zudzin
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {



}
