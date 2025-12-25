/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author 20128
 */
public class Room {
    private int id;
    private int floor;
    private int capacity;
    private String type;
    private String description;
    private float price ;
    ArrayList<String> ReservedDates;
    public Room(int id, int floor, int capacity, String type, String description, float price) {
        this.id = id;
        this.floor = floor;
        this.capacity = capacity;
        this.type = type;
        this.description = description;
        this.price = price;
        ReservedDates=new ArrayList<>();
    }

    public Room() {
        ReservedDates=new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void reserve(LocalDate startDate,LocalDate finishDate){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-mm-dd");
        for(LocalDate date=startDate;date.isBefore(finishDate);date=date.plusDays(1)){
            String d=date.format(formatter);
            ReservedDates.add(d);
        }
    }
    public boolean isReserved(LocalDate startDate,LocalDate finishDate){
        boolean b=false;
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-mm-dd");
        for(LocalDate date=startDate;date.isBefore(finishDate);date=date.plusDays(1)){
            String d=date.format(formatter);
            if(ReservedDates.contains(d)) {
                b=true;
                break;
                        
            }
            
        }
        return b;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", floor=" + floor + ", capacity=" + capacity + ", type=" + type + ", description=" + description + ", price=" + price + '}';
    }
    
}
