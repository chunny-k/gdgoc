package GDGoC_study.hello_spring.User_Controll;

import GDGoC_study.hello_spring.User_Model.User;
import GDGoC_study.hello_spring.User_Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 생성자 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 엔드포인트
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userRequest) {
        User savedUser = userService.newUser(
                userRequest.getEmails(),
                userRequest.getSecret_num(),
                userRequest.getNickname()
        );

        if (savedUser == null) {
            // 이메일 중복 등의 이유로 실패한 경우
            return ResponseEntity.badRequest().body("이미 사용 중인 이메일입니다.");
        }

        // 성공
        return ResponseEntity.ok(savedUser);
    }


    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateUserByEmail(
            @PathVariable("email") String email,
            @RequestBody User updateData) {
        try {
            User updatedUser = userService.updateUser(email, updateData);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}