package by.netcracker.hotel.controllers;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UserNotFoundException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

/**
 * @author Yauheni Shopik
 * @since 4/7/2017
 */
@Controller
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String save(UserDTO dto) {
        System.out.println(dto);
        return "true";
    }

}
