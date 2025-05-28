package GDGoC_study.hello_spring.User_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import GDGoC_study.hello_spring.Hello_Entity.NoticeBoard;

public interface NoticeRepository extends JpaRepository<NoticeBoard, Long> {
}
