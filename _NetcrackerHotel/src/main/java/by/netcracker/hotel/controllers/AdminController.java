package by.netcracker.hotel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.ReviewService;
import by.netcracker.hotel.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final ReviewService reviewService;

    @Autowired
    public AdminController(UserService userService, ReviewService reviewService) {
        this.userService = userService;
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/add_user_ref", method = RequestMethod.GET)
    public String getAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add_user";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/add_user";
        }
        try {
            user.setAuthority(ROLE.USER);
            User added = (User) userService.addEnabledUser(user);
        } catch (UsernameExistException e) {
            model.addAttribute("error", "Account with username - " + user.getUsername() + " are exist");
            return "add_user";
        } catch (EmailExistException e) {
            model.addAttribute("error", "Account with email - " + user.getEmail() + " are exist");
            return "add_user";
        }
        model.addAttribute("success", "User - " + user.getUsername() + " was added.");
        return "admin/admin_page";
    }

    @RequestMapping(value = "/edit_form/{username}", method = RequestMethod.GET)
    public String getEditForms(@Valid @PathVariable("username") String username, Model model) {
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "admin/user_editing";
    }

    @RequestMapping(value = "/block_user", method = RequestMethod.POST)
    public String blockUser(@Valid @ModelAttribute("user") User user, Model model) {
        userService.blockUser(user);
        model.addAttribute("users", userService.getAll());
        return "admin/list_of_users";
    }

    @RequestMapping(value = "/unblock_user", method = RequestMethod.POST)
    public String unblockUser(@Valid @ModelAttribute("user") User user, Model model) {
        userService.unblockUser(user);
        model.addAttribute("users", userService.getAll());
        return "admin/list_of_users";
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.POST)
    public String deleteUser(@Valid @ModelAttribute("user") User user, Model model) {
        userService.deleteUserByUsername(user.getUsername());
        model.addAttribute("success", "User - " + user.getUsername() + " was successfully deleted.");
        return "admin/admin_page";
    }

    @RequestMapping(value = "/check_review/{id}", method = RequestMethod.GET)
    public String checkReview(@Valid @PathVariable("id") int id, Model model) {
        Review review = reviewService.getByID(id);
        // reviewService.update(review);
        model.addAttribute("review", review);
        return "admin/check_review";
    }

    @RequestMapping(value = "/check_review/{id}", method = RequestMethod.POST)
    public String checkedReview(@Valid @ModelAttribute("review") Review review, @PathVariable("id") int id,
        Model model) {
        reviewService.update(review);
        review = reviewService.getByID(id);
        model.addAttribute("review", review);
        return "admin/check_review";
    }

}
