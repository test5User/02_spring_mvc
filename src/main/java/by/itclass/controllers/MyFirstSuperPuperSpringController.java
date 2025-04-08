package by.itclass.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyFirstSuperPuperSpringController {
    public String viewIndex() {
        return "index";
    }
}
