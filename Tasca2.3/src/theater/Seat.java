package theater;

public class Seat {

    private final int rowNum;
    private final int seatNum;
    private final String client;

    public Seat(int rowNum, int seatNum, String client) {
        this.rowNum = rowNum;
        this.seatNum = seatNum;
        this.client = client;
    }

    public Seat(int rowNum, int seatNum) {
        this.rowNum = rowNum;
        this.seatNum = seatNum;
        this.client = "";
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Seat)) {
            return false;
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
