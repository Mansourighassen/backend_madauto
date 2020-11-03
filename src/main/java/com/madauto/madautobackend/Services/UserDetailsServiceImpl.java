package com.madauto.madautobackend.Services;

import com.madauto.madautobackend.dao.ClientRepository;
import com.madauto.madautobackend.entities.Client;
import com.madauto.madautobackend.entities.User;
import com.madauto.madautobackend.exceptions.ClientnotfoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(s);
        Client client = clientOptional.orElseThrow(()->new ClientnotfoundException("no client found :"+s));
        return new org.springframework.security.core.userdetails.User(client.getEmail(),client.getPassword(),true,true,true,true,getAuthorities("USER"));

    }

    private Collection <? extends GrantedAuthority> getAuthorities(String Role){
        return Collections.singletonList(new SimpleGrantedAuthority(Role));
    }
}
