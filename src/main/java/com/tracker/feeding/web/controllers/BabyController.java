//package com.tracker.feeding.web.controllers;
//
//import com.tracker.feeding.models.Baby;
//import com.tracker.feeding.repositories.BabyRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.time.LocalDate;
//
//@Controller
//public class BabyController {
//    private final BabyRepository babyDao;
//
//    public BabyController(BabyRepository babyDao) {
//        this.babyDao = babyDao;
//    }
//
//    @GetMapping("/mybaby")
//    public String addBaby(Model model){
//        model.addAttribute("baby", new Baby());
//        return "babies/babyprofile";
//    }
//
//    @PostMapping("/addbaby")
//    public String saveBaby(@ModelAttribute Baby baby) {
//        babyDao.save(baby);
//        return "redirect:/mybaby";
//    }
//
//    @PostMapping("/mybaby/update")
//    public String updateBaby(
//            @RequestParam(name="id") long id,
//            @RequestParam(name="name") String name,
//            @RequestParam(name="dob") String dob,
//            @RequestParam(name="url") String url
//    ) {
//        Baby baby = babyDao.getOne(id);
//        baby.setName(name);
//        java.util.Date dobSql = java.sql.Date.valueOf(LocalDate.parse(dob));
//        baby.setDob(dobSql);
//        baby.setUrl(url);
//
//        babyDao.save(baby);
//        return "redirect:/mybaby";
//    }
//}
