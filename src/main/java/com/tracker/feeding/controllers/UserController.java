package com.tracker.feeding.controllers;

import com.tracker.feeding.models.User;
import com.tracker.feeding.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user/profile")
    public String userProfile(Model model) {
        model.addAttribute("user", userDao.getOne(user.getId()));
        return "/users/profile";
    }

    @PostMapping("/user/update")
    public String updateUser(
        @RequestParam(name="id") long id,
        @RequestParam(name="username") String username,
        @RequestParam(name="email") String email,
        @RequestParam(name="first_name") String first_name,
        @RequestParam(name="last_name") String last_name,
        @RequestParam(name="password_old") String password_old,
        @RequestParam(name="password_new") String password_new,
        @RequestParam(name="url") String url
        ) {
        User user = userDao.getOne(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setUrl(url);
        if (!password_old.isEmpty() && !password_new.isEmpty()) {
            if (passwordEncoder.encode(password_old).equals(user.getPassword()))
                user.setPassword(passwordEncoder.encode(password_new));
        }
        userDao.save(user);
        return "redirect:/user/profile";
    }
}
