package com.tihic.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RestaurantRepository repository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "loginregister";
    }

    @GetMapping("/register_fastfood")
    public String showSignUpFormFastFood(Model model) {
        model.addAttribute("user", new User());
        return "loginregister_fastfood";
    }

    @PostMapping("/loginregister")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPass = encoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        repo.save(user);

        return "loginregister";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
        List<User> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/list_restaurant")
    public String viewRestourantList(Model model) {
        List<Restaurant> listRestaurant = repository.findAll();
        model.addAttribute("listRestaurant", listRestaurant);

        return "fastfood_order_page";
    }
}
