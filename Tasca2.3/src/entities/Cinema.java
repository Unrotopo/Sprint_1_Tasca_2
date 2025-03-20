package entities;

import managers.*;

import java.util.Scanner;

public class Cinema {

    private final Scanner sc = new Scanner(System.in);
    private int numRows;
    private int numSeatsPerRow;
    public static SeatManagement seatManagement;
    public static CinemaManagement cinemaManagement;

    public Cinema() {
        seatManagement = new SeatManagement();
        cinemaManagement = new CinemaManagement(this);
        demandInitialData();
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumSeatsPerRow() {
        return numSeatsPerRow;
    }

    public void setNumSeatsPerRow(int numSeatsPerRow) {
        this.numSeatsPerRow = numSeatsPerRow;
    }

    public void demandInitialData() {
        System.out.println("Enter the number of rows in the cinema: ");
        int rows = sc.nextInt();
        setNumRows(rows);
        System.out.println("The cinema has " + rows + " rows.\n");
        sc.nextLine();
        System.out.println("Enter the number of seats per row: ");
        int seats = sc.nextInt();
        setNumSeatsPerRow(seats);
        System.out.println("The cinema has " + seats + " seats per row.\n");
        sc.nextLine();
    }

    public void start() {
        cinemaManagement.menu();
    }
}
