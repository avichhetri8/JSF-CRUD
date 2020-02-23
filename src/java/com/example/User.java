/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author avi
 */
@ManagedBean(name="user")
@RequestScoped
public class User {
    int id;
    String name;
    ArrayList<String> courses;
    String course;
    String address;
    Integer phone;
    String shift;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    public String getAddress() {
        return address;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setCourse(ArrayList<String> courses) {
        this.courses = courses;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
         
    }
   
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    
    
    public String displayValue(){
        return "Your name is "+name;
    }
   
    /**
     * Creates a new instance of User
     */
    public User() {
        courses =new ArrayList<String>();
        courses.add("management");
        courses.add("science");
        courses.add("humanities");
    }
    
}
