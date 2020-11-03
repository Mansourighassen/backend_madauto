package com.madauto.madautobackend.Services;

import com.madauto.madautobackend.dao.ClientRepository;
import com.madauto.madautobackend.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ClientService {

@Autowired
    ClientRepository cl ;

public Client SignupClient(Client client) {
    try {
        return cl.save(client);
    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }
}
@Transactional
public Client findbyemail(String email){
    return cl.findByEmail(email);
}



  public String findclientbyemailorphone (Client c){
      for (Client k:cl.findAll()
           ) {
                 if(c.getEmail().equals(k.getEmail()))
                     return "invalid";

      }
      return "valid";
}

public  Client authentification(String email , String password){
    System.out.println(cl.findClientByEmailAndPassword(email,password));
    return this.cl.findClientByEmailAndPassword(email,password);

}


public List<Client> getallclient(){
    return this.cl.findAll();
}
@Transactional
public  Boolean updateclient(Client ca){
    if( this.cl.findClientByEmail(ca.getEmail()).isPresent()){
        Client c = cl.findByEmail(ca.getEmail());
        c.setZipcode(ca.getZipcode());
        c.setGouvernorat(ca.getGouvernorat());
        c.setPhonenumber(ca.getPhonenumber());
        c.setGouvernorat(ca.getGouvernorat());
        c.setFirstname(ca.getFirstname());
        c.setLastname(ca.getLastname());
        c.setAddress(ca.getAddress());
        c.setEmail(ca.getEmail());
        c.setRecordStatus(ca.getRecordStatus());
        c.setRaisonsocial(c.getRaisonsocial());
        cl.save(c);
        return  true;
    }
    return  false;
}
@Transactional
public Boolean deleteclient(Client ca){
    cl.delete(ca);
    return  true;
}

}

