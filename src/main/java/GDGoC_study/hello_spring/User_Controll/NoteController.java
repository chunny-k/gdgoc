package GDGoC_study.hello_spring.User_Controll;

import GDGoC_study.hello_spring.Hello_Entity.NoticeBoard;
import GDGoC_study.hello_spring.User_Service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoteController {
    private final NoticeService noticeService;

    public NoteController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
    @PostMapping("/usenote")
    public ResponseEntity<NoticeBoard> usenotice(@RequestBody NoticeBoard noticeBoard) {
        NoticeBoard newNotice = noticeService.create(noticeBoard);
        return ResponseEntity.ok(newNotice);

    }

}
