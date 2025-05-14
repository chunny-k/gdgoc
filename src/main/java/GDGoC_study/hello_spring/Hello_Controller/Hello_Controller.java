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

    @GetMapping("/hellomvc")
    public String helloMvc(@RequestParam("data") String data, Model model) {
        model.addAttribute("data", data);
        return "hellomvc";
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

    @GetMapping("/hellosm")
    @ResponseBody
    public String helloSm(@RequestParam("data") String data) {
        return "hi" + data;
    }



    @GetMapping("/pvsm")
    @ResponseBody
    public hellos psvm(@RequestParam("name") String name) {
        hellos helloss = new hellos();
        helloss.setName(name);
        return helloss;
    }
    static class hellos {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
