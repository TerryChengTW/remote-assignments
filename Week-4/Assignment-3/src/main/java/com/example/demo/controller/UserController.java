package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/member")
    public String member() {
        return "member"; // 渲染 templates 目錄中的 member.html
    }


    @PostMapping("/signup")
    public String signUp(@RequestParam String email, @RequestParam String password, Model model){
        logger.info("(con)Received request to add user: {}", email);
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(email);
        userRequest.setPassword(password);

        if (userService.isEmailRegistered(email)) {
            model.addAttribute("errorMessage", "Email already registered.");
            logger.info("(con)Registered failed, email already existed.");
            model.addAttribute("signinEmail", email);
            return "home";
        }

        Integer userId = userService.addUser(userRequest);
        logger.info("(con)User registered with ID: {}", userId);
        return "redirect:/member";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String email, @RequestParam String password, Model model){
        logger.info("(con)Received request to sign in with email: {}", email);

        User user = userService.validateUser(email, password);
        if(user ==null) {
            if(!userService.isEmailRegistered(email)) {
                model.addAttribute("errorMessage","Email not registered.");
                logger.info("(con)Sign in failed, email not registered.");
                model.addAttribute("signupEmail", email);
            } else {
                model.addAttribute("errorMessage","Incorrect password.");
                logger.info("(con)Sign in failed, incorrect password.");
                model.addAttribute("signinEmail", email);
            }
            return "home";
        }
        return "redirect:/member";
    }
}
