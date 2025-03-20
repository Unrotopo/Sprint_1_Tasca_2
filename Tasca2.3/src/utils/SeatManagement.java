package utils;

import exceptions.FreeSeatException;
import objects.Seat;

import java.util.ArrayList;

public class SeatManagement {

    private static ArrayList<Seat> seats;

    public SeatManagement() {
        seats = new ArrayList<>();
    }

    public static ArrayList<Seat> getSeats() {
        return seats;
    }

    public static void addSeat(Seat seat) throws FreeSeatException {
        if (searchSeat(seat.getRowNum(), seat.getSeatNum()) == -1) {
            seats.add(seat);
        } else {
            throw new FreeSeatException("The selected seat is already occupied\n");
        }
    }

    public static void removeSeat(int rowNum, int seatNum) throws FreeSeatException {
        if (searchSeat(rowNum, seatNum) != -1) {
            seats.remove(searchSeat(rowNum, seatNum)); // LOCALIZAO
        } else {
            throw new FreeSeatException("The selected seat is already free\n");
        }
    }

    public static int searchSeat(int rowNum, int seatNum) {
        Seat newSeat = new Seat(rowNum, seatNum, null);
        for (int i = 0; i < seats.size(); i++) {
            if (Seat.equals(newSeat)) {
                return i;
            }
        }
        return -1;
    }
}
