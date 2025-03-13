package objects;

public class Seat {

    private int rowNum;
    private int seatNum;
    private String client;

    public Seat(int rowNum, int seatNum, String client) {
        this.rowNum = rowNum;
        this.seatNum = seatNum;
        this.client = client;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getClient() {
        return client;
    }

    /*
    Faltan métodos para:
    Equals: retornarà que dues butaques són iguales si la fila i el seient són iguals.

    toString: retornarà un String amb el següent format: “Fila: 5, Seient: 20, Persona: Maria Febrer”
     */
}
