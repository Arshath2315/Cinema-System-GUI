import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CinemaTicketReservationSystem {
    private RatingManager ratingManager;
    private ReservationManager reservationManager;
    private LoyaltyPointSystem loyaltyPointSystem;

    public CinemaTicketReservationSystem() {
        ratingManager = new RatingManager();
        reservationManager = new ReservationManager();
        loyaltyPointSystem = new LoyaltyPointSystem();
    }

    public void addUser(User user) {
        loyaltyPointSystem.addUser(user);
    }

    public void addPoints(User user, int points) {
        loyaltyPointSystem.addPoints(user, points);
    }

    public int getPoints(User user) {
        return loyaltyPointSystem.getPoints(user);
    }

    public double purchaseTicket(User user, double ticketPrice, int pointsToSpend) {
        return loyaltyPointSystem.purchaseTicket(user, ticketPrice, pointsToSpend);
    }
}
