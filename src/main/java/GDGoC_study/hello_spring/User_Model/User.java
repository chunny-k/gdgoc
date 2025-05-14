package GDGoC_study.hello_spring.User_Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String emails;
    @Column(nullable = false)
    private String secret_num;
    @Column(nullable = false)
    private String nickname;

}
