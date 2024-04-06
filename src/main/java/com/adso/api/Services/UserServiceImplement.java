package com.adso.api.Services; 
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import com.adso.api.Models.Vehiculo; 
import com.adso.api.Interfaces.UserRepository; 

@Service
public class UserServiceImplement implements UserService {

    @Autowired 
    private final UserRepository userRepository; 
    public UserServiceImplement(UserRepository userRepository){ 
        this.userRepository = userRepository;
     } 
     public List<Vehiculo> findAll() { 
        return (List<Vehiculo>) userRepository.findAll(); 
    } 
    @SuppressWarnings("null") 
    public Vehiculo save(Vehiculo vehiculo) { 
        return userRepository.save(vehiculo);
     } 
     
     @SuppressWarnings("null") 
     public Vehiculo findById(long id) { 
        return userRepository.findById(id).orElse(null);
     } 
     @SuppressWarnings("null") 
     public void delete(Vehiculo vehiculo) { 
        userRepository.delete(vehiculo); 
    }

}