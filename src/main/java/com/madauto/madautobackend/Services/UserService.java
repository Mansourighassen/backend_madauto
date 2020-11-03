package com.madauto.madautobackend.Services;

import com.madauto.madautobackend.dao.UserRepository;
import com.madauto.madautobackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    UserRepository ur ;


    public User authentificateuser(String username,String password){
        return  this.ur.findUserByUsernameAndPassword(username,password);
    }
}
