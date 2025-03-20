package managers;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;
import entities.*;

import static entities.Cinema.seatManagement;

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
                    showSeats().forEach(System.out::println);
                    break;
                case 2:
                    showClientSeats().forEach(System.out::println);
                    break;
                case 3:
                    bookSeat();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    showClientSeats().forEach(seat -> {
                        try {
                            seatManagement.removeSeat(seat.getRowNum(), seat.getSeatNum());
                        } catch (FreeSeatException e) {
                            System.out.println(e.getMessage());
                        }
                    });
                    System.out.println("All client's bookings have been removed.\n");
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

    public ArrayList<Seat> showSeats() {
        return seatManagement.getSeats();
    }

    public ArrayList<Seat> showClientSeats() {
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
        for (Seat seat : seatManagement.getSeats()) {
            if (clientName.equals(seat.getClient())) {
                clientSeats.add(seat);
            }
        }
        return clientSeats;
    }

    public void bookSeat() {
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
            seatManagement.addSeat(seat);
            System.out.println("Seat booked successfully.\n");
        } catch (FreeSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelBooking() {
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
            seatManagement.removeSeat(bookedRow, bookedSeat);
        } catch (FreeSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public String introduceClientName() throws IncorrectClientNameException {
        System.out.println("Please, introduce client's name:");
        String name = sc.nextLine();
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IncorrectClientNameException("Name cannot contain numbers\n");
            }
        }
        return name;
    }

    public int introduceRow() throws IncorrectRowException {
        System.out.println("Please, select the row:");
        int row = sc.nextInt();
        if (row >= 1 && row <= cinema.getNumRows()) {
            sc.nextLine();
            return row;
        } else {
            throw new IncorrectRowException("The selected row does not exist.\n");
        }
    }

    public int introduceSeat() throws IncorrectSeatException {
        System.out.println("Please, select the seat:");
        int seat = sc.nextInt();
        if (seat >= 1 && seat <= cinema.getNumSeatsPerRow()) {
            sc.nextLine();
            return seat;
        } else {
            throw new IncorrectSeatException("The selected seat does not exist.\n");
        }
    }
}