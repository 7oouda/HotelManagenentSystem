/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 20128
 */
public class GuestController {
        public static void addNewGuest(ArrayList<Guest> guests,Scanner scanner){
            System.out.println("Enter Guest Name: ");
            String name=scanner.next();
            System.out.println("Enter Guest Email: ");
            String email=scanner.next();
            System.out.println("Enter Guest Discount: ");
            int disc=scanner.nextInt();
            int id=10000+guests.size();
            Guest guest=new Guest(id,name,email,disc);
            guests.add(guest);
            System.out.println("Guest added Succesfully");
            
        }
        public static void showGuests(ArrayList<Guest> guests){
            for(Guest g:guests){
//                System.out.println("_____________________");
                System.out.println(g.toString());
                System.out.println("_____________________");

            }
        }
        public static ArrayList<Guest> searchGuest(ArrayList<Guest> guests,Scanner scanner){
            ArrayList<Guest> guest1 = new ArrayList<Guest>();
            Guest guest=new Guest();
            System.out.println("Enter Guest Name:");
            String name=scanner.next();
            
            for(Guest g:guests ){
                if(g.getName().equals(name)){
                    guest=g;
//                    break;
                    guest1.add(guest);

                }
            }
            return guest1;
        }
        public static void editGuestData(ArrayList<Guest> guests,Scanner scanner){
            System.out.println("Enter Guest Id \n-1 to Show All Guest");
            int id=scanner.nextInt();
            if(id==-1){
                showGuests(guests);
                System.out.println("Enter Guest Id \n-1 to Show All Guest");
                int guestId=scanner.nextInt();
                id=guestId;
            }
            Guest guest=getGuestById(id ,guests);
            System.out.println("Enter Name: \n -1 to keep it");
            String name=scanner.next();
            if(name.equals("-1")){
                name=guest.getName();
            }
            System.out.println("Enter Email: \n -1 to keep it");
            String email=scanner.next();
            if(email.equals("-1")){
                email=guest.getEmail();
            }
            System.out.println("Enter Discount: \n -1 to keep it");
            int disc=scanner.nextInt();
            if(disc==-1){
                disc=guest.getDiscount();
            }
            guest.setName(name);
            guest.setEmail(email);
            guest.setDiscount(disc);
            for(Guest g:guests){
                if(g.getId()==id){
                    g=guest;
                    break;
                }
            }
        }
        public static Guest getGuestById(int id,ArrayList<Guest> guests){
            Guest guest=new Guest();
            for(Guest g: guests){
                if(id==g.getId()){
                    guest=g;
                    break;
                }
                
        }
            return guest;
        }

}
