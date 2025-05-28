package GDGoC_study.hello_spring.User_Service;

import GDGoC_study.hello_spring.Hello_Entity.NoticeBoard;
import GDGoC_study.hello_spring.User_Repository.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {this.noticeRepository = noticeRepository;}


    public NoticeBoard create(NoticeBoard newData) {

        return noticeRepository.save(newData);
    }
}
