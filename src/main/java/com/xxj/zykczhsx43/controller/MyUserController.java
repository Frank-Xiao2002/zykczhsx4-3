package com.xxj.zykczhsx43.controller;

import com.xxj.zykczhsx43.entity.User;
import com.xxj.zykczhsx43.service.MyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyUserController {
    private final MyUserService userService;

    public MyUserController(MyUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/insertPage")
    public String index() {
        return "insertPage";
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/userList")
    public String userList(Model model) {
        List<User> all = userService.findAll();
        model.addAttribute("users", all);
        return "userList";
    }


    @RequestMapping("/insert")
    public String save(User user) {
        userService.save(user);
        return "redirect:/userList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/userList";

    }

    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model, @PathVariable int id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "updatePage";
    }

    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/userList";
    }
}
