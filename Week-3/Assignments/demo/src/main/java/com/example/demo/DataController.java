package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/data")
    public String getData(@RequestParam(value="number", required = false) String number) {
        if (number == null) {
            return "Lack of Parameter";
        }
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                return "Wrong Parameter(number should be greater than zero)";
            }
            int ans = (1 + num) * num / 2;
            return Integer.toString(ans);
        } catch (NumberFormatException e) {
            return "Wrong Parameter";
        }
    }
}