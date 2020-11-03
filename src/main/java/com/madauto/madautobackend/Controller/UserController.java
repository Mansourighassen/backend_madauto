package com.madauto.madautobackend.Controller;

import com.madauto.madautobackend.Services.UserService;
import com.madauto.madautobackend.entities.Product;
import com.madauto.madautobackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class UserController {
    @Autowired
    UserService us = new UserService();
    @GetMapping(path="/authentification/userlogin",produces ={ "application/json"})
   @CrossOrigin("*")
    public ResponseEntity<User> authentification(@RequestParam("user") String user, @RequestParam("password") String password){
       User u =  us.authentificateuser(user,password) ;


        if (u == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        return  new ResponseEntity<User>(u, HttpStatus.OK);

    }

}
