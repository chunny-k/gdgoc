package GDGoC_study.hello_spring.Hello_Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Hello_Controller {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "GET 요청입니다!");
        return "hello";
    }

    @PostMapping("/hello")
    public String postHello(Model model) {
        model.addAttribute("message", "POST 요청입니다!");
        return "hello";
    }

    @PutMapping("/hello")
    @ResponseBody
    public String putHello() {
        return "PUT 요청 처리됨";
    }

    @DeleteMapping("/hello")
    @ResponseBody
    public String deleteHello() {
        return "DELETE 요청 처리됨";
    }
}
