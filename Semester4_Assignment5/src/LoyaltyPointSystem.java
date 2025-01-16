import java.util.HashMap;
import java.util.Map;

public class LoyaltyPointSystem {
    private Map<User, Integer> loyaltyPoints;
    private double discountRate;
    public LoyaltyPointSystem() {
        loyaltyPoints = new HashMap<>();
    }

    public void addUser(User user) {
        loyaltyPoints.putIfAbsent(user, 0);
    }

    public void addPoints(User user, int points) {
        loyaltyPoints.merge(user, points, Integer::sum);
    }

    public int getPoints(User user) {
        return loyaltyPoints.getOrDefault(user, 0);
    }

    public double calculateDiscount(User user, double ticketPrice,int pointsToSpend) {
        int points = loyaltyPoints.getOrDefault(user, 0);
        double discountRate = pointsToSpend > 0 ? pointsToSpend / 100.0 : 0; // Assume 1 point = 1% discount
        double discount = Math.min(discountRate, 1.0) * ticketPrice; // Cap discount at 100%
        return discount;
    }

    public double purchaseTicket(User user, double ticketPrice, int pointsToSpend) {
        double discount = calculateDiscount(user, ticketPrice, pointsToSpend);
        double discountedPrice = ticketPrice - discount;
        if (discountedPrice < ticketPrice) {
            loyaltyPoints.put(user, loyaltyPoints.getOrDefault(user, 0) - pointsToSpend);
        }
        return discountedPrice;
    }

}
