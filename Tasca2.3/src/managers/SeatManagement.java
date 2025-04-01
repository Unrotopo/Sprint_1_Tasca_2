package managers;

import exceptions.FreeSeatException;
import theater.Seat;

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
        if (searchSeat(seat.getRowNum(), seat.getSeatNum()) != -1) {
            throw new FreeSeatException("The selected seat is already occupied\n");
        } else {
            seats.add(seat);
        }
    }

    public void removeSeat(int rowNum, int seatNum) throws FreeSeatException {
        if (searchSeat(rowNum, seatNum) == -1) {
            throw new FreeSeatException("The selected seat is already free\n");
        } else {
            seats.remove(searchSeat(rowNum, seatNum));
        }
    }

    public int searchSeat(int rowNum, int seatNum) {
        Seat newSeat = new Seat(rowNum, seatNum);
        for (int i = 0; i < seats.size(); i++) {
            if (newSeat.equals(seats.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
