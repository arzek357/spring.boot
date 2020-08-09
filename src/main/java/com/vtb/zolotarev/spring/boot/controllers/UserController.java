package com.vtb.zolotarev.spring.boot.controllers;

import com.vtb.zolotarev.spring.boot.model.Product;
import com.vtb.zolotarev.spring.boot.model.User;
import com.vtb.zolotarev.spring.boot.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/showAll")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "all_users";
    }

    @PostMapping(value = "/add")
    public String saveNewUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user/showAll";
    }

    @GetMapping(value = "/remove/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/user/showAll";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditUserPage(Model model,@PathVariable long id){
        model.addAttribute("user",userService.findUserById(id));
        return "user_edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/user/showAll";
    }
}
