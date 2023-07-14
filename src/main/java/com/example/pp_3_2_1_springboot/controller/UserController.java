package com.example.pp_3_2_1_springboot.controller;

import com.example.pp_3_2_1_springboot.dto.UserDto;
import com.example.pp_3_2_1_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String usersList(ModelMap model) {
        model.addAttribute("users", userService.getListOfUsers());
        return "users";
    }

    @GetMapping("/add")
    public String showFormForAddUser(ModelMap model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "add";

    }
    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") UserDto userDto){
        userService.add(userDto);
        return "redirect:/";
    }


    @GetMapping("/update")
    public String showFormForUpdateUser(ModelMap model, @RequestParam(name = "id") Long id){
        UserDto userDto = userService.findById(id);
        model.addAttribute("user", userDto);
        return "update";

    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") UserDto userDto){
        userService.merge(userDto);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

}
