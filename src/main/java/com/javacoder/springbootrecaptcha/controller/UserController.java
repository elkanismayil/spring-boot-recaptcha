package com.javacoder.springbootrecaptcha.controller;

import com.javacoder.springbootrecaptcha.entity.User;
import com.javacoder.springbootrecaptcha.service.IUserService;
import com.javacoder.springbootrecaptcha.util.CaptchaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private CaptchaValidator validator;

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model, @RequestParam("g-recaptcha-response") String captcha) {
        if (validator.isValidCaptcha(captcha)) {
            Integer id = service.createUser(user);
            model.addAttribute("message", "User with id : '" + id + "' saved successfully!");
            model.addAttribute("user", new User());
        }else {
            model.addAttribute("message","Please validate captcha first");
        }
        return "register_user";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model){
        List<User> users = service.getAllUsers();
        model.addAttribute("list",users);
        return "list_users";
    }
}
