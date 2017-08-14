package com.gearcloud.core.controllers;

import com.gearcloud.core.repositories.ProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    private ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @RequestMapping("/profiles")
    public String getProfiles(Model model) {
        model.addAttribute("profiles", profileRepository.findAll());
        return "profiles";
    }
}
