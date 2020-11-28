package com.tracker.feeding.controllers;

import com.tracker.feeding.models.Baby;
import com.tracker.feeding.repositories.BabyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BabyController {
    private final BabyRepository babyDao;

    public BabyController(BabyRepository babyDao) {
        this.babyDao = babyDao;
    }

    @GetMapping("/mybaby")
    public String addBaby(Model model){
        model.addAttribute("baby", new Baby());
        return "babies/addbaby";
    }

    @PostMapping("/addbaby")
    public String saveBaby(@ModelAttribute Baby baby) {
        babyDao.save(baby);
        return "redirect:/addbaby";
    }
}
