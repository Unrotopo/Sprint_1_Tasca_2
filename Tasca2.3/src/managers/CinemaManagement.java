package managers;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;
import theater.*;

import static theater.Cinema.seatManagement;

public class CinemaManagement {

    public final Cinema cinema;
    static Scanner sc = new Scanner(System.in);

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
    }

    public void menu() {
        int option;

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
                    cancelAllSeatsFromClient();
                    break;
                default:
                    System.out.println("Invalid option!\nTry with a number from 0 to 5.\n");
            }
        } while (option != 0);
    }

    public ArrayList<Seat> showSeats() {
        return seatManagement.getSeats();
    }

    public ArrayList<Seat> showClientSeats() {
        String clientName = null;
        ArrayList<Seat> clientSeats = new ArrayList<>();
        do {
            try {
                clientName = introduceClientName();
                break;
            } catch (IncorrectClientNameException e) {
                System.out.println(e.getMessage());
            }
        } while (clientName == null);

        for (Seat seat : seatManagement.getSeats()) {
            if (clientName.equals(seat.getClient())) {
                clientSeats.add(seat);
            }
        }
        return clientSeats;
    }

    public void cancelAllSeatsFromClient() {
        showClientSeats().forEach(seat -> {
            try {
                seatManagement.removeSeat(seat.getRowNum(), seat.getSeatNum());
            } catch (FreeSeatException e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("All client's bookings have been removed.\n");
    }

    public void bookSeat() {
        int desiredRow;
        int desiredSeat;
        String clientName;

        while (true) {
            try {
                desiredRow = introduceRow();
                desiredSeat = introduceSeat();
                clientName = introduceClientName();
                break;

            } catch (IncorrectRowException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectSeatException e) {
                throw new RuntimeException(e);
            } catch (IncorrectClientNameException e) {
                throw new RuntimeException(e);
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
                bookedSeat = introduceSeat();
                break;
            } catch (IncorrectRowException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectSeatException e) {
                throw new RuntimeException(e);
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

        if (!(row >= 1 && row <= cinema.getNumRows())) {
            throw new IncorrectRowException("The selected row does not exist.\n");
        } else {
            sc.nextLine();
            return row;
        }
    }

    public int introduceSeat() throws IncorrectSeatException {
        System.out.println("Please, select the seat:");
        int seat = sc.nextInt();

        if (!(seat >= 1 && seat <= cinema.getNumSeatsPerRow())) {
            throw new IncorrectSeatException("The selected seat does not exist.\n");
        } else {
            sc.nextLine();
            return seat;
        }
    }
}