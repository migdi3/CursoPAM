package com.entelgy.clientepam.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("titulo", "Bienvenido a Curso Red Hat PAM");
        return "inicio";
    }

}
