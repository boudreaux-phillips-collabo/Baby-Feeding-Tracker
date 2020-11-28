package com.tracker.feeding.controllers;

import com.tracker.feeding.models.Baby;
import com.tracker.feeding.repositories.BabyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BabyController {
    private final BabyRepository babyDao;

    public BabyController(BabyController babyDao) {
        this.babyDao = babyDao;
    }

    @GetMapping("/baby")
    public String addBaby(Model model){
        model.addAttribute("baby", new Baby());
        return "babies/addbaby";
    }
}
