package GDGoC_study.hello_spring.User_Repository;

import GDGoC_study.hello_spring.User_Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmails(String emails);

    String emails(String emails);
}
