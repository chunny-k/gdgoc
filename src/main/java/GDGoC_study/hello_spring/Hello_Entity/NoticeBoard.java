package GDGoC_study.hello_spring.Hello_Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name="notice")
@Getter
@Setter
public class NoticeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardID; // 메모장 아이디
    @Column (nullable = false)
    private String notice; // 내용
    @Column (nullable = false)
    private String titles; // 메모제목
    @Column (nullable = false)
    private LocalDateTime createtimes; // 메모 기록시간

    @PrePersist
    protected void onCreate() {
        createtimes = LocalDateTime.now();
    }


}
