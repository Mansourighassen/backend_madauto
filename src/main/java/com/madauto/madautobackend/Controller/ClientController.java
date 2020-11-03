package com.madauto.madautobackend.Controller;

import com.madauto.madautobackend.Services.ClientService;
import com.madauto.madautobackend.entities.Client;
import com.madauto.madautobackend.entities.RecordStatus;
import com.madauto.madautobackend.entities.Responseobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ClientController {
    @Autowired
    ClientService cs ;



@PostMapping(value="/api/client/signups",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Responseobject> postCustomer(@RequestBody Client customer){
        String response = null;
            response=cs.findclientbyemailorphone(customer);
        System.out.println(response);
            if (response.equals("valid")){
                    customer.setRecordStatus(RecordStatus.inactive);
                cs.SignupClient(customer);

                return new ResponseEntity<>(new Responseobject(response,"ok"), HttpStatus.OK);
            }
        return new ResponseEntity<Responseobject>(new Responseobject(response,"found"), HttpStatus.FOUND);
    }


    @GetMapping(path="/authentification/clientlogin",produces ={ "application/json"})
    @CrossOrigin("*")
    public ResponseEntity<Client> authentification(@RequestParam("email") String email, @RequestParam("password") String password){
        Client c =  cs.authentification(email,password) ;
        System.out.println(c.getEmail());

        if (c == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        return  new ResponseEntity<Client>(c, HttpStatus.OK);

    }

}
