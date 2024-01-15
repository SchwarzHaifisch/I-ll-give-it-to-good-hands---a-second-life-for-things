package pl.coderslab.loginSystem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
class LoginController {

    private final UserService userService;

    @GetMapping
    String login(@RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            // Błąd logowania
        }
        return "login";
    }


    @PostMapping
    String loginPost(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("dupa1");
            return "redirect:/user/main";
        } else {
            System.out.println("dupa2");
            return "login";
        }
    }
}