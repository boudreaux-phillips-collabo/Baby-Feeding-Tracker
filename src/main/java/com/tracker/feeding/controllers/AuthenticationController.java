package com.tracker.feeding.controllers;

import com.tracker.feeding.models.User;
import com.tracker.feeding.repositories.BabyRepository;
import com.tracker.feeding.repositories.RecordRepository;
import com.tracker.feeding.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

public class AuthenticationController {
    private final BabyRepository babyDao;
    private final UserRepository userDao;
    private final RecordRepository recordDao;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(BabyRepository babyDao, UserRepository userDao, RecordRepository recordDao, PasswordEncoder passwordEncoder) {
        this.babyDao = babyDao;
        this.userDao = userDao;
        this.recordDao = recordDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginForm() { return "login"; }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode((user.getPassword()));
        user.setPassword(hash);
        userDao.save(user);
        user.setUrl(user.getUrl());
        LocalDate date = LocalDate.now();
        java.util.Date dateVal = java.sql.Date.valueOf(date);
        user.setSignupDate(dateVal);

        return "redirect:/profile";
    }
}
