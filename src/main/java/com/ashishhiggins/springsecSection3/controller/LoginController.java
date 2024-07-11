package com.ashishhiggins.springsecSection3.controller;

import com.ashishhiggins.springsecSection3.model.Customer;
import com.ashishhiggins.springsecSection3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){

        Customer savedCustomer = null;
        ResponseEntity responseEntity = null;


        try {
            savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId() > 0){
                responseEntity = ResponseEntity.status(HttpStatus.OK).body("Given User Details are Saved Successfully");
            }
        }
        catch (Exception exception){
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to "+ exception.getMessage());
        }
        return responseEntity;

    }
}
