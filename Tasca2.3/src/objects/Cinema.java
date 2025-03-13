package objects;

import utils.CinemaManagement;
import utils.SeatManagement;

public class Cinema {

    private int numRows;
    private int numSeatsPerRow;
    private SeatManagement seatManagement;
    private CinemaManagement cinemaManagement;
    private Cinema cinema;

    public Cinema() {
        this.seatManagement = new SeatManagement();
        this.cinemaManagement = new CinemaManagement(cinema);

    }

    public void demandInicialData(int rowNum, int seatNum) {

    }

    public void start() {

    }
}
