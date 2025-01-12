package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HeaderController {

    @ModelAttribute("username")
    public String getLoggedInUsername(Authentication authentication) {
        return authentication != null ? authentication.getName() : null;
    }
}

