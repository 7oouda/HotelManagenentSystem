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
 *     private int capacity;
    private String type;
    private String description;
    private float price ;
 */
public class RoomController {
    public static void AddNewRoom(ArrayList<Room> rooms,Scanner scanner){
        System.out.println("Enter Floor :");
        int floor=scanner.nextInt();
        System.out.println("Enter Capacity :");
        int capacity=scanner.nextInt();
        System.out.println("Enter Type :");
        String type=scanner.next();
        System.out.println("Enter Description :");
        String description=scanner.next();
        System.out.println("Enter Price :");
        float price=scanner.nextFloat();
        int id=1000+rooms.size();
        Room room=new Room(id,floor,capacity,type,description,price);
        rooms.add(room);
        System.out.println("Room added Succesfully");
    }
        public static void showRooms(ArrayList<Room> rooms){
            for (Room room:rooms){
//                System.out.println("_____________________");
                System.out.println(room.toString());
                System.out.println("_____________________");

//                System.out.println("");
            }
        }
    public static void editRoom(ArrayList<Room> rooms,Scanner scanner){
        System.out.println("Enter Room Id : \n -1 to Show All Rooms");
        int id=scanner.nextInt();
//        int id;
        if(id==-1){
            showRooms(rooms);
            System.out.println("Enter Room Id : \n -1 to Show All Rooms");
            int j=scanner.nextInt();
            id=j;
        }
        Room room=getRoomById(id, rooms);
        System.out.println("Enter Floor: \n -1 to keep it");
        int floor=scanner.nextInt();
        if(floor==-1){
            floor=room.getFloor();
        }
        System.out.println("Enter Capacity: \n -1 to keep it");
        int cap=scanner.nextInt();
        if(cap==-1){
            cap=room.getCapacity();
        }
        System.out.println("Enter Type: \n -1 to keep it");
        String type=scanner.next();
        if(type.equals("-1")){
            type=room.getType();
        }
        System.out.println("Enter Discription: \n -1 to keep it");
        String disc=scanner.next();
        if(disc.equals("-1")){
            disc=room.getDescription();
        }
        System.out.println("Enter Price: \n -1 to keep it");
        float Price=scanner.nextFloat();
        if(Price==-1){
            Price=room.getPrice();
        }
        room.setType(type);
        room.setFloor(floor);
        room.setCapacity(cap);
        room.setDescription(disc);
        room.setPrice(Price);
        room.setCapacity(cap);
        for(Room r:rooms){
            if(r.getId()==id){
                r=room;
                break;
            }
        }
    }
     public static Room getRoomById(int id,ArrayList<Room> rooms){
            Room room=new Room();
            for(Room r :rooms){
                if(r.getId()==id){
                    room=r;
                    break;
                    
                            
                }
            }
            return room;

        }


    
}
