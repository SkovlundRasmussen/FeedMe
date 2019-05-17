package com.test_project.demo.controller;

import com.test_project.demo.model.User;
import com.test_project.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //RequestMapping maps URL
    @RequestMapping(value= {"/", "/login"}, method= RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;
    }

    //Get signup page
    @GetMapping(value= {"/signup"})
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");

        return model;
    }

    //Post create user on signuppage
    @PostMapping(value= {"/signup"})
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) throws Exception {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());


        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("user/login");
        }

        return model;
    }

    //Get homepage and display user
    @GetMapping(value= {"/home/home"})
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
        model.setViewName("home/home");
        return model;
    }

    //If you dont have permission to view page redirect to access_denied
    @GetMapping(value= {"/access_denied"})
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }

}