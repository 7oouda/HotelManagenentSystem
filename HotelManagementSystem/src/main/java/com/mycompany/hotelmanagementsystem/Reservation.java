/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 20128
 */
public class Reservation {
    private int id;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double price;
    private String status;
    private Guest guest;
    private Room room;
    private DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Reservation(LocalDate arrivalDate, LocalDate departureDate, double price, String status, Guest guest, Room room) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
        this.status = status;
        this.guest = guest;
        this.room = room;
    }

    public Reservation() {
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
    public String getArrivalDateToString() {
        return arrivalDate .format(formatter);
    }
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }
    public String getDepartureDateToString() {
        return departureDate.format(formatter);
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" + "arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", price=" + price + ", status=" + status + ", guest=" + guest + ", room=" + room + ", formatter=" + formatter + ", Id=" + id+ '}';
    }
    
}
