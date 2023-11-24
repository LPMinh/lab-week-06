package com.minh.labweek06.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class RegisterController {
    @GetMapping(value = {"/register"})
    public String displayPageRegister() {
        return "register";
    }
}
