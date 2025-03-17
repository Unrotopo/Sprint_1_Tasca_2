package utils;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;
import objects.*;

public class CinemaManagement {

    public final Cinema cinema;
    static Scanner sc = new Scanner(System.in);

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
    }

    public void menu() {
        int option;
        boolean flag = true;

        do {
            System.out.println("""
                    -----  CINEMA MANAGEMENT  -----
                    1. Show booked seats
                    2. Show client's booked seats
                    3. Book a seat
                    4. Cancel a booking
                    5. Cancel all client's bookings
                    0. Exit
                    """);
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    CinemaManagement.showSeats().forEach(System.out::println);
                    break;
                case 2:
                    CinemaManagement.showClientSeats().forEach(System.out::println);
                    break;
                case 3:
                    CinemaManagement.bookSeat();
                    break;
                case 4:
                    CinemaManagement.cancelBooking();
                    break;
                case 5:
                    CinemaManagement.showSeats().forEach(seat -> {
                        try {
                            SeatManagement.removeSeat(seat.getRowNum(), seat.getSeatNum());
                        } catch (FreeSeatException e) {
                            System.out.println(e.getMessage());
                        }
                    });
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!\nTry with a number from 0 to 5.\n");
            }
        } while (flag);
    }

    public static ArrayList<Seat> showSeats() {
        return SeatManagement.getSeats();
    }

    public static ArrayList<Seat> showClientSeats() {
        String clientName;
        ArrayList<Seat> clientSeats = new ArrayList<>();
        while (true) {
            try {
                clientName = introduceClientName();
                break;
            } catch (IncorrectClientNameException e) {
                System.out.println(e.getMessage());
            }
        }
        for (Seat seat : SeatManagement.getSeats()) {
            if (clientName.equals(seat.getClient())) {
                clientSeats.add(seat);
            }
        }
        return clientSeats;
    }

    public static void bookSeat() {
        int desiredRow;
        int desiredSeat;
        String clientName;
        while (true) {
            try {
                desiredRow = introduceRow();
                break;
            } catch (IncorrectRowException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                desiredSeat = introduceSeat();
                break;
            } catch (IncorrectSeatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                clientName = introduceClientName();
                break;
            } catch (IncorrectClientNameException e) {
                System.out.println(e.getMessage());
            }
        }
        Seat seat = new Seat(desiredRow, desiredSeat, clientName);
        try {
            SeatManagement.addSeat(seat);
            System.out.println("Seat booked successfully\n");
        } catch (FreeSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cancelBooking() {
        int bookedRow;
        int bookedSeat;

        while (true) {
            try {
                bookedRow = introduceRow();
                break;
            } catch (IncorrectRowException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                bookedSeat = introduceSeat();
                break;
            } catch (IncorrectSeatException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            SeatManagement.removeSeat(bookedRow, bookedSeat);
        } catch (FreeSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String introduceClientName() throws IncorrectClientNameException {
        System.out.println("Please, introduce client's name:");
        String name = sc.nextLine();
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IncorrectClientNameException("Name cannot contain numbers\n");
            }
        }
        return name;
    }

    public static int introduceRow() throws IncorrectRowException {
        System.out.println("Please, select the row:");
        int row = sc.nextInt();
        if (row >= 1 && row <= Cinema.getNumRows()) {
            sc.nextLine();
            return row;
        } else {
            throw new IncorrectRowException("The selected row does not exist");
        }
    }

    public static int introduceSeat() throws IncorrectSeatException {
        System.out.println("Please, select the seat:");
        int seat = sc.nextInt();
        if (seat >= 1 && seat <= Cinema.getNumSeatsPerRow()) {
            sc.nextLine();
            return seat;
        } else {
            throw new IncorrectSeatException("The selected seat does not exist");
        }
    }
}