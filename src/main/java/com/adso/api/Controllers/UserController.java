package com.adso.api.Controllers; 

import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 

import org.springframework.web.bind.annotation.RestController;

import com.adso.api.Models.Vehiculo;
import com.adso.api.Services.UserService; 

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 


@RestController 
@RequestMapping("/api") 
public class UserController { 
    
    private final UserService userService;
    
    public UserController(UserService userService){
         this.userService = userService; 
    } 
    
    @GetMapping(value="/vehiculo") 
    public ResponseEntity<Object> get(){
         Map<String, Object> map = new HashMap<String, Object>();
         try {
            List<Vehiculo> list = userService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
         }
         catch (Exception e) {
             map.put("message", e.getMessage()); 
             return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR); 
         }
    }

    @GetMapping(value="/vehiculo/{id}") 
    public ResponseEntity<Object> getById(@PathVariable Long id){ 
        try { 
            Vehiculo data = userService.findById(id);
             return new ResponseEntity<Object>(data,HttpStatus.OK);
        } 
        catch (Exception e) { 
            Map<String, Object> map = new HashMap<String, Object>();
             map.put("message", e.getMessage());
              return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @PostMapping(value="/vehiculo") 
    public ResponseEntity<Object> create(@RequestBody Vehiculo vehiculo){ 
        Map<String, Object> map = new HashMap<String, Object>(); 
        try { 
            Vehiculo res = userService.save(vehiculo);
             return new ResponseEntity<Object>(res,HttpStatus.OK);
        } 
        catch (Exception e) { map.put("message", e.getMessage());
         return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @PutMapping("/vehiculo/{id}") 
    public ResponseEntity<Object> update(@RequestBody Vehiculo vehiculo, @PathVariable Long
id){ 
      Map<String, Object> map = new HashMap<String, Object>(); 
      try { 
        Vehiculo existingUser = userService.findById(id); 
        
        existingUser.setModel(vehiculo.getModel()); 
        existingUser.setBrand(vehiculo.getBrand());
        existingUser.setEnginetype(vehiculo.getEnginetype()); 
        existingUser.setColor(vehiculo.getColor()); 
        
        Vehiculo res = userService.save(vehiculo);
        return new ResponseEntity<Object>(res,HttpStatus.OK);
     } 
     catch (Exception e) { 
        map.put("message", e.getMessage());
        return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }
    @DeleteMapping("/vehiculo/{id}")
     public ResponseEntity<Object> delete(@PathVariable Long id){
         Map<String, Object> map = new HashMap<String, Object>();
          try { 
              Vehiculo existingUser = userService.findById(id);
              userService.delete(existingUser); 
              map.put("deleted", true);
              return new ResponseEntity<Object>(map,HttpStatus.OK);
          } 
          catch (Exception e) { 
            map.put("message", e.getMessage()); 
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR); 
          } 
     } 
}           