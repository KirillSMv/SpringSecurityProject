package com.development.centerAt.security;

import com.development.centerAt.security.model.AppUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class GreetingsController {
    @GetMapping("/home")
    public String greetings() {
        return "home";
    }

    @GetMapping("/user/home")
    public String greetingsUser() {
        System.out.println("/user/home gets called");
        return "home_user";
    }

    @GetMapping("/admin/home")
    public String greetingsAdmin() {
        System.out.println("/admin/home gets called");
        return "home_admin";
    }

    //Метод с доступом к данным пользователя
    @GetMapping("/user/details")
    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();
        return appUserDetails.getUsername();
    }
}
