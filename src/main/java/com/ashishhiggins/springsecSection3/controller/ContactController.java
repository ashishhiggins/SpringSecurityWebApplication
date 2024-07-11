package com.ashishhiggins.springsecSection3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String getContact() {
        return "Here are the contact details from the DB";
    }
}
