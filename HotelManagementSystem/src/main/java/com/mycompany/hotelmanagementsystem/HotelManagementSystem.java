/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 20128
 */
public class HotelManagementSystem {
    private static ArrayList<Room> rooms;
    private static ArrayList<Guest> guests;
    private static ArrayList<Employee> employee;
    private static ArrayList<Reservation> reservation;


    public static void main(String[] args) {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        employee = new ArrayList<>();
        reservation = new ArrayList<>();
        int i=0;
        while (i!=17){
            
        System.out.println("Welcome from Hotel Management System");
        System.out.println("1.Add New Room");
        System.out.println("2.Show All Room");
        System.out.println("3.Edit Room");
        System.out.println("4.Add New Guest");
        System.out.println("5.Show All Guest");
        System.out.println("6.Search Guest By name");
        System.out.println("7.Edit Guest Data");
        System.out.println("8.Create New Reservation");
        System.out.println("9.Show All Reservation");
        System.out.println("10.Get Reservation By Guest Name");
        System.out.println("11.Get Reservation By ID");
        System.out.println("12.Edit Reservaton");
        System.out.println("13.pay Reservaton");
        System.out.println("14.Add New Employee");
        System.out.println("15.Show All Employees");
        System.out.println("16.Edit Employee");
        System.out.println("17.Quit");

        Scanner scanner=new Scanner(System.in);
        i=scanner.nextInt();
            switch (i) {
                case 1:
                    RoomController.AddNewRoom(rooms,scanner);
                    break;
                case 2:
                    RoomController.showRooms(rooms);
                    break;
                case 3:
                    RoomController.editRoom(rooms,scanner);
                    break;
                case 4:
                    GuestController.addNewGuest(guests,scanner);
                    break;
                case 5:
                    GuestController.showGuests(guests);
                    break;
                case 6:
                    ArrayList<Guest> guest1=GuestController.searchGuest(guests,scanner);
                    for(Guest g: guest1){
                        System.out.println(g);
                    }
                    break;
                case 7:
                    GuestController.editGuestData(guests,scanner);
                    break;
                case 8:
                    ResservationsController.createNewReservation(guests, rooms, reservation, scanner);
                    break;

                case 9:
                    ResservationsController.showAllReservation(reservation,scanner);
                    break;

                case 10:
                    ResservationsController.gatReservationByGuestName(reservation, scanner);
                    break;
                case 11:
                    ResservationsController.gatReservationByGuestId(reservation, scanner);
                    break;
                case 12:
                    ResservationsController.editReservation(guests, rooms, reservation, scanner);
                    break;
                case 13:
                    ResservationsController.payReservation(reservation, scanner);
                    break;
                case 14:
                    EmployeeController.addEmployee(employee, scanner);
                    break;
                case 15:
                    EmployeeController.showEmployees(employee);
                    break;
                case 16:
                    EmployeeController.editEmployee(employee, scanner);
                    break;
                case 17:
                    scanner.close();
                    break;
            }
        
        }


    }
}
