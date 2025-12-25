/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 20128
 * private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double price;
    private String status;
    private Guest guest;
    private Room room;
 */
public class ResservationsController {
        private static DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void createNewReservation(ArrayList<Guest> guests,ArrayList<Room> rooms,ArrayList<Reservation> reservation,Scanner scanner){
        int id=reservation.size()+100;
        System.out.println("Enter Arrival Date: ");
        String arrDate=scanner.next();
        System.out.println("Enter Departure Date: ");
        String depDate=scanner.next();
//        System.out.println("Enter Reservation Price: ");
//        double price=scanner.nextDouble();
        System.out.println("Enter guest Id \n -1 to search guest by name ");
        int guestId=scanner.nextInt();
        if (guestId==-1){
            System.out.println(GuestController.searchGuest(guests, scanner));
            System.out.println("Enter guest id: ");
            guestId=scanner.nextInt();

        }
        System.out.println("Enter Room Id \n -1 to show All rooms");
        int roomId=scanner.nextInt();
        if(roomId==-1){
            RoomController.showRooms(rooms);
            System.out.println("Enter Room Id :");
            roomId=scanner.nextInt();
        }
        
        LocalDate arrivalDate=LocalDate.parse(arrDate, formatter);
        LocalDate departureDate=LocalDate.parse(depDate, formatter);
        Guest guest=GuestController.getGuestById(guestId, guests);
        Room room=RoomController.getRoomById(roomId, rooms);
        if(room.isReserved(departureDate, arrivalDate)){
            System.out.println("This room is Resserved");
            return;
        }else{
            int days=Period.between(arrivalDate,departureDate).getDays();
            double sum=days*room.getPrice();
            double total=sum-sum*guest.getDiscount()/100;
            System.out.println("Total before Discount: "+sum);
            System.out.println("Total after Discount: "+total);
            System.out.println("Will You Pay Now? \n1.Yes\n2.No");
            int j=scanner.nextInt();
            String status;
            if(j==1){
                status="Paid";
            }else{
                status="Reserved";
            }
            Reservation r=new Reservation(arrivalDate,departureDate,total,status,guest,room);
            r.toString();
            reservation.add(r);
            
        }
    }
    public static void showAllReservation(ArrayList<Reservation>reserve,Scanner scanner){
        for(Reservation r:reserve){
            System.out.println("_________________________");
            System.out.println("Arrival Date: "+r.getArrivalDateToString());
            System.out.println("Departure Date: "+r.getDepartureDateToString());
            System.out.println("Guest Name: "+r.getGuest().getName());
            System.out.println("Room Id: "+r.getRoom().getId());
            System.out.println("Price: "+r.getPrice());
            System.out.println("Status: "+r.getStatus());
            System.out.println("_________________________");

        }
    }
    public static void gatReservationByGuestName(ArrayList<Reservation>reserve,Scanner scanner){
        System.out.println("Enter Guest Name: ");
        String guestName=scanner.next();
        for(Reservation r:reserve){
            String name=r.getGuest().getName();
            if(guestName.equals(name))r.toString();
        }
    }
    public static void gatReservationByGuestId(ArrayList<Reservation>reserve,Scanner scanner){
        System.out.println("Enter Guest Id: ");
        int guestId=scanner.nextInt();
        for(Reservation r:reserve){
            int name=r.getGuest().getId();
            if(guestId==name)
                r.toString();
        }
    }
    public static void editReservation(ArrayList<Guest> guests,ArrayList<Room> rooms,ArrayList<Reservation> reservation,Scanner scanner){
        System.out.println("Enter Reservation Id\n -1 To Show All Reservation");
        int id=scanner.nextInt();
        if(id==-1){
            showAllReservation(reservation, scanner);
            System.out.println("Enter Reservation Id: ");
            id=scanner.nextInt();
        }
        Reservation r=reservation.get(id);
        System.out.println("Enter Arrival Date: \n-1 to keep it");
        String arrDate=scanner.next();
        if(arrDate.equals("-1")){
            arrDate=r.getArrivalDateToString();
        }
        System.out.println("Enter Departure Date:\n-1 to keep it ");
        String depDate=scanner.next();
        if(depDate.equals("-1")){
            depDate=r.getDepartureDateToString();
        }
        System.out.println("Enter Room Id:\n-1 to keep it\n-2 to show all rooms ");
        int roomId=scanner.nextInt();
        if(roomId==-1){
            roomId=r.getRoom().getId();
        }else if(roomId==-2){
            RoomController.showRooms(rooms);
            System.out.println("Enter Room Id:");
            roomId=scanner.nextInt();

        }
        LocalDate arrivalDate=LocalDate.parse(arrDate, formatter);
        LocalDate departureDate=LocalDate.parse(depDate, formatter);
        Guest guest=r.getGuest();
        Room room=RoomController.getRoomById(roomId, rooms);
        if(room.isReserved(departureDate, arrivalDate)){
            System.out.println("This room is Resserved");
            return;
        }else{
            int days=Period.between(arrivalDate,departureDate).getDays();
            double sum=days*room.getPrice();
            double total=sum-sum*guest.getDiscount()/100;
            System.out.println("Total before Discount: "+sum);
            System.out.println("Total after Discount: "+total);
            System.out.println("Will You Pay Now? \n1.Yes\n2.No");
            int j=scanner.nextInt();
            String status;
            if(j==1){
                status="Paid";
            }else{
                status="Reserved";
            }
            r.setArrivalDate(arrivalDate);
            r.setDepartureDate(departureDate);
            r.setGuest(guest);
            r.setPrice(total);
            r.setRoom(room);
            r.setStatus(status);
            reservation.set(id, r);
            r.toString();
            
        }
    }
    public static void payReservation(ArrayList<Reservation> reservations,Scanner scanner){
        System.out.println("Enter Reservation Id\n -1 To Show All Reservation");
        int id=scanner.nextInt();
        if(id==-1){
            showAllReservation(reservations, scanner);
            System.out.println("Enter Reservation Id: ");
            id=scanner.nextInt();
        }
        Reservation reservation=reservations.get(id);
        if(reservation.getStatus().equals("Reserved")){
            reservation.setStatus("Paid");
            System.out.println("Reservation Paid Succesfully");
        }else{
            System.out.println("this Reservation Already paid");
        }
    }

}
