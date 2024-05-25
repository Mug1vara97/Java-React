package com.example.zxc.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.zxc.models.User;
import com.example.zxc.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
    
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("register request: " + user);
        return userService.registerUser(user.getUsername(), user.getPassword(), user.getEmail());
    }

    @PostMapping("/test")
    public User login(@RequestBody User user) {
        System.out.println("login request: " + user);
        return userService.authenticate(user.getUsername(), user.getPassword());
    }
}

/*package com.example.zxc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.zxc.models.User;
import com.example.zxc.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/register")
        public String register(@ModelAttribute User user) {
            System.out.println("register request: " + user);
            User registeredUser = userService.registerUser(user.getUsername(), user.getPassword(), user.getEmail());
            return registeredUser == null ? "error_page" : "redirect:/login";
        }
    
        @PostMapping("/test")
        public String login(@ModelAttribute User user, Model model) {
            System.out.println("login request: " + user);
            User authenticated = userService.authenticate(user.getUsername(), user.getPassword());
            if (authenticated != null) {
                model.addAttribute("userUsername", authenticated.getUsername());
                return "personal_page";
            } else {
                return "error_page";
            }
        }
}
*/