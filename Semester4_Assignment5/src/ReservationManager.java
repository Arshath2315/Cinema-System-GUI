import java.util.*;
public class ReservationManager {

    private Stack<Reservation> reservationStack;

    public ReservationManager() {
        reservationStack = new Stack<>();
    }

    public void makeReservation(Reservation reservation) {
        reservationStack.push(reservation);
    }

    public Reservation cancelLatestReservation() {
        if (!reservationStack.isEmpty()) {
            return reservationStack.pop();
        } else {
            return null; // Stack is empty, no reservations to cancel
        }
    }

    public void displayReservation(Reservation reservation) {
        System.out.println(reservation.toString());
    }

}
