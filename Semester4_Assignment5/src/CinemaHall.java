import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaHall {
    private int hallNumber;
    private int seatingCapacity;
    private int[][] seats;

    public CinemaHall(int hallNumber, int seatingCapacity, int numRows, int numCols) {
        this.hallNumber = hallNumber;
        this.seatingCapacity = seatingCapacity;
        this.seats = new int[numRows][numCols];
        // Initialize all seats as available (0 represents available, 1 represents reserved)
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                seats[i][j] = 0;
            }
        }
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isSeatAvailable(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length && seats[row][col] == 0;
    }

    public boolean reserveSeat(int row, int col) {
        if (isSeatAvailable(row, col)) {
            seats[row][col] = 1; // Reserve the seat
            return true;
        } else {
            return false; // Seat already reserved or invalid
        }
    }

    public void displaySeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(seats[i][j] == 0 ? "O " : "X "); // O for available, X for reserved
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "CinemaHall{" +
                "hallNumber=" + hallNumber +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }
}
