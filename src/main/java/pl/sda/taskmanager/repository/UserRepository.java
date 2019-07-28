package pl.sda.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.taskmanager.model.User;

/**
 * @author Remigiusz Zudzin
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmailAndPassword(String email, String password);

}
