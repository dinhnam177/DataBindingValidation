package com.example.databindingvalidate.controller;

import com.example.databindingvalidate.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Comparator;

@Controller
public class UserController {

    @GetMapping("/")
    public String getValidate(Model model){
        model.addAttribute("user", new User());
        return "validate";
    }

    @PostMapping("/validate")
    public String processForm(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            var errorStream = bindingResult.getAllErrors().stream();
            errorStream.sorted(Comparator.comparing(ObjectError::getDefaultMessage));
            return "validate";
        }
        model.addAttribute("user",user);
            return "index";
    }
}
