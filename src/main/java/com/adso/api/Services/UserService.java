package com.adso.api.Services; 

import java.util.List; 

import org.springframework.stereotype.Service; 

import com.adso.api.Models.Vehiculo; 

@Service 
public interface UserService {                              
    public List<Vehiculo> findAll(); 
    public Vehiculo save(Vehiculo vehiculo);

    public Vehiculo findById(long id);

    public void delete(Vehiculo vehiculo);

}
