package objects;

import utils.CinemaManagement;

public class Seat {

    private final int rowNum;
    private final int seatNum;
    private String client;

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

    public static boolean equals(Seat seat) {
        for (Seat existingSeat : CinemaManagement.showSeats()) {
            if (existingSeat.getRowNum() == seat.getRowNum() &&
                    existingSeat.getSeatNum() == seat.getSeatNum()) {
                return true;
            }
        } return false;
    }

    public String toString() {
        return "Row: " + this.rowNum +
                ", Seat: " + this.seatNum +
                ", Client: " + this.client;
    }

}
