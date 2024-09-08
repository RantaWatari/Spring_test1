package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Hello {
    @GetMapping("hello")
    public String getMethodName(Model model) {
        String fuck = "Fuck Microsoft!!";
        String[] helloModel = {"Hello1","Hello2","Hello!! Fuck Microsoft!!"};
        model.addAttribute("Hello", helloModel);
        model.addAttribute("Fuck", fuck);
        return "hello";
    }
    
}
