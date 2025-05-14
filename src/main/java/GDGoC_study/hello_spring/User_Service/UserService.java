package GDGoC_study.hello_spring.User_Service;

import GDGoC_study.hello_spring.User_Repository.UserRepository;
import org.springframework.stereotype.Service;
import GDGoC_study.hello_spring.User_Model.User;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(String emails, User newUserData) {
        // 1. 기존 사용자 조회
        User existingUser = userRepository.findByEmails(emails)
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일의 사용자를 찾을 수 없습니다: " + emails));

        // 2. 필드 수정
        existingUser.setEmails(newUserData.getEmails());
        existingUser.setSecret_num(newUserData.getSecret_num());
        existingUser.setNickname(newUserData.getNickname());

        // 3. 저장 후 반환
        return userRepository.save(existingUser);
    }
    public User newUser(String emails, String secret_num, String nickname) {

        User user = new User();
        if (userRepository.findByEmails(emails).isPresent()) {
            System.out.println("중복 이메일 존재");
            return null;
        }
        user.setEmails(emails);
        user.setSecret_num(secret_num);
        user.setNickname(nickname);
        return userRepository.save(user);
    }



}