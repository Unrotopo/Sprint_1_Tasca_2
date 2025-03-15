package objects;

import utils.CinemaManagement;
import utils.SeatManagement;

import java.util.Scanner;

public class Cinema {

    private final Scanner sc = new Scanner(System.in);
    private static int numRows;
    private static int numSeatsPerRow;
    private final SeatManagement seatManagement;
    private final CinemaManagement cinemaManagement;

    public Cinema() {
        seatManagement = new SeatManagement();
        cinemaManagement = new CinemaManagement(this);
        demandInitialData();
    }

    public static int getNumRows() {
        return numRows;
    }

    public static void setNumRows(int numRows) {
        Cinema.numRows = numRows;
    }

    public static int getNumSeatsPerRow() {
        return numSeatsPerRow;
    }

    public static void setNumSeatsPerRow(int numSeatsPerRow) {
        Cinema.numSeatsPerRow = numSeatsPerRow;
    }

    public void demandInitialData() {
        System.out.println("Enter the number of rows in the cinema: ");
        int rows = sc.nextInt();
        Cinema.setNumRows(rows);
        System.out.println("The cinema has " + rows + " rows.\n");
        sc.nextLine();
        System.out.println("Enter the number of seats per row: ");
        int seats = sc.nextInt();
        Cinema.setNumSeatsPerRow(seats);
        System.out.println("The cinema has " + seats + " seats per row.\n");
        sc.nextLine();
    }

    public void start() {
        cinemaManagement.menu();
    }
}
