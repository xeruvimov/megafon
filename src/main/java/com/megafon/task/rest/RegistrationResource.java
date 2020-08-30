package com.megafon.task.rest;

import com.megafon.task.dto.UserDTO;
import com.megafon.task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@AllArgsConstructor
@Controller
public class RegistrationResource {

    private final UserService userService;


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserDTO user, Map<String, Object> model) {
        userService.registerNewUserAccount(user);
        return "redirect:/login";
    }
}
