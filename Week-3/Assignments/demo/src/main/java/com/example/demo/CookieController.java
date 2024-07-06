package com.example.demo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CookieController {

    @GetMapping("/myname")
    @ResponseBody
    public String myName(@CookieValue(value = "username", defaultValue = "") String username) {
        if (username.isEmpty()) {
            return "<form action='/trackName'>" +
                    "<label for='name'>Enter your name:</label>" +
                    "<input type='text' id='name' name='name'>" +
                    "<button type='submit'>Submit</button>" +
                    "</form>";
        }else {
            return "<h1>Hi, " + username + "!</h1>";
        }
    }


    @GetMapping("/trackName")
    public String trackName(@RequestParam String name, HttpServletResponse response) {
        Cookie cookie = new Cookie("username", name);
        response.addCookie(cookie);
        return "redirect:/myname";
    }


}