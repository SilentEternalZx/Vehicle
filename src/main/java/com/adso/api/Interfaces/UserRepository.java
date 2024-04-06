package com.adso.api.Interfaces; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import com.adso.api.Models.Vehiculo; 
@Repository 
public interface UserRepository extends JpaRepository<Vehiculo, Long> {
    
}



