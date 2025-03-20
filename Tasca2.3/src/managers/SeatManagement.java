package managers;

import exceptions.FreeSeatException;
import entities.Seat;

import java.util.ArrayList;

public class SeatManagement {

    private ArrayList<Seat> seats;

    public SeatManagement() {
        seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) throws FreeSeatException {
        if (searchSeat(seat.getRowNum(), seat.getSeatNum()) == -1) {
            seats.add(seat);
        } else {
            throw new FreeSeatException("The selected seat is already occupied\n");
        }
    }

    public void removeSeat(int rowNum, int seatNum) throws FreeSeatException {
        if (searchSeat(rowNum, seatNum) != -1) {
            seats.remove(searchSeat(rowNum, seatNum));
        } else {
            throw new FreeSeatException("The selected seat is already free\n");
        }
    }

    public int searchSeat(int rowNum, int seatNum) {
        Seat newSeat = new Seat(rowNum, seatNum, null);
        for (int i = 0; i < seats.size(); i++) {
            if (newSeat.equals(seats.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
