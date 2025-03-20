package entities;

import managers.CinemaManagement;

import static entities.Cinema.cinemaManagement;
import static entities.Cinema.seatManagement;

public class Seat {

    private final int rowNum;
    private final int seatNum;
    private final String client;

    public Seat(int rowNum, int seatNum, String client) {
        this.rowNum = rowNum;
        this.seatNum = seatNum;
        this.client = client;
    }

    public int getRowNum() {
        return this.rowNum;
    }

    public int getSeatNum() {
        return this.seatNum;
    }

    public String getClient() {
        return this.client;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {

        }
        Seat seat = (Seat) object;
        return this.rowNum == seat.rowNum && this.seatNum == seat.seatNum;
    }

    @Override
    public String toString() {
        return "Row: " + this.rowNum +
                ", Seat: " + this.seatNum +
                ", Client: " + this.client;
    }

}
