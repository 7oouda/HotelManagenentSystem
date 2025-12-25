/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem;

/**
 *
 * @author 20128
 */
public class Guest {
    private int id;
    private String name;
    private String email;
    private int discount;

    public Guest(int id, String name, String email, int discount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.discount = discount;
    }

    public Guest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Guest{" + "id=" + id + ", name=" + name + ", email=" + email + ", discount=" + discount + '}';
    }
    
    
}
