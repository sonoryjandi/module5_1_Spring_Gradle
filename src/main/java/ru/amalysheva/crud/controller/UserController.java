package ru.amalysheva.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.amalysheva.crud.entities.User;
import ru.amalysheva.crud.service.MyService;

@Controller
public class UserController {
    private final MyService<User> service;

    @Autowired
    public UserController(MyService<User> service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String showAllUsersList(Model model) {
        model.addAttribute("users", service.getAll());
        return "user_list_page";
    }

    @GetMapping("/create")
    public String showCreateUserForm() {
        return "create_user_page";
    }

    @PostMapping("/create")
    public String createUser(@RequestParam String login, @RequestParam String password) {
        User user = User.builder()
                .login(login)
                .password(password)
                .build();
        service.create(user);
        return "redirect:/users";
    }

    //TODO
//    @GetMapping("/users/{id}")
//    public String getUserInfo(@PathVariable int id, Model model) {
//        model.addAttribute("users", service.getUserInfo(id));
//        return "get_user_info_page";
//    }

//    @GetMapping("/users/{id}")
//    @ResponseBody
//    public String getUserInfo(@PathVariable Integer id){
//        return service.getUserInfo(id);
//    }

    @GetMapping("users/{id}")
    @ResponseBody
    public String getUserInfo(@PathVariable Integer id){
        return "User info: " + service.getUserInfo(id);
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUserById(@PathVariable int id) {
        service.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/users/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("id",id);
        return "update_user_page";
    }


    @PostMapping("/users/update/{id}")
    public String updateUserById(@PathVariable int id, String login, String password){
        service.update(id, login, password);
        return "redirect:/users";
    }
}
