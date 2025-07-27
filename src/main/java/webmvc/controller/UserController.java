package webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmvc.model.User;
import webmvc.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("newUser", new User());
        model.addAttribute("updateUser", new User());
        return "users";
    }

    @PostMapping
    public String save(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PutMapping
    public String update(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping
    public String delete(@RequestParam int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
