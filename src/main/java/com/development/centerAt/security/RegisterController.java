package com.development.centerAt.security;

import com.development.centerAt.appuser.dto.AppUserDto;
import com.development.centerAt.appuser.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RegisterController {
    private final PasswordEncoder passwordEncoder;
    private final AppUserService appUserService;

    @PostMapping("/registration/user")
    public String performRegistration(@ModelAttribute("user") AppUserDto appUserDto) {
        appUserDto.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
        //роль админа добавляется вручную в базе данных
        appUserDto.setRole("ROLE_ADMIN");
        log.debug("appUserDto = {}", appUserDto);
        appUserService.addAppUser(appUserDto);
        return "redirect:/auth/login";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") AppUserDto appUserDto) {
        return "registration_page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login_page";
    }
}
