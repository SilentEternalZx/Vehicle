package com.adso.api.Models; 
import java.io.Serializable; 


import jakarta.persistence.*; 
import jakarta.validation.constraints.NotBlank; 

@Entity 
@Table(name="vehiculo") 
public class Vehiculo implements Serializable {

 private static final long serialVersionUID = 1L;

 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY) 
 @Column(name = "id") private Long id;

 @NotBlank 
 @Column(name = "model") private String model;

 @Column(name = "brand") private String brand;
 
 @Column(name = "enginetype") private String enginetype;

 @Column(name = "color")  private String color;

 public Long getId(){
    return id;
 }
 public void setId(long id){
    this.id=id;
 }
 public String getModel(){
    return model;
 }
 public void setModel(String model){
 this.model=model;
 }

 public String getBrand(){
    return brand;
 }
 public void setBrand(String brand){
 this.brand=brand;
}

 public String getEnginetype(){
    return enginetype;
 }
 
 public void setEnginetype(String enginetype){
    this.enginetype=enginetype;
 }
 public String getColor(){
    return color;
 }

 public void setColor(String color){
    this.color=color;
 }
}