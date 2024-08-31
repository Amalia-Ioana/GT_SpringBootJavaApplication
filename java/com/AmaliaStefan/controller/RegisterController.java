package com.AmaliaStefan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.AmaliaStefan.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }
    
    @PostMapping
    public ModelAndView registerUser(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        String role = "ROLE_USER"; // Setează rolul în mod explicit doar pentru user
        if (userService.registerNewUser(username, password, role)) {
            return new ModelAndView("redirect:/login");
        } else {
            return new ModelAndView("register").addObject("message", "Error during registration");
        }
    }
    
//  @PostMapping
//  public ModelAndView registerUser(@RequestParam("username") String username,
//                                   @RequestParam("password") String password,
//                                   @RequestParam("role") String role) {
//  	
//      // Asigură-te că rolul nu este "admin"
//      if ("admin".equalsIgnoreCase(role)) {
//          role = "user";
//      }
//      
//      if (userService.registerNewUser(username, password, role)) {
//          return new ModelAndView("redirect:/login");
//      } else {
//          return new ModelAndView("register").addObject("message", "Error during registration");
//      }
//  }
}
