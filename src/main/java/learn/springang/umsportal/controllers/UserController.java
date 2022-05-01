package learn.springang.umsportal.controllers;

import learn.springang.umsportal.exceptions.ExceptionHandling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/", "/user"})
public class UserController extends ExceptionHandling {

    @GetMapping("/home")
    public String showUser() {
        return "application works";
    }
}
