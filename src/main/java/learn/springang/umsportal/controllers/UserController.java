package learn.springang.umsportal.controllers;

import learn.springang.umsportal.exceptions.ExceptionHandling;
import learn.springang.umsportal.exceptions.domain.EmailExistsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser() throws EmailExistsException {
        throw new EmailExistsException("Testing EmailExistsException handling");
        //return "application works";
    }
}
