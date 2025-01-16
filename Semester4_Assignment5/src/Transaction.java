import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Transaction {
    public enum Type {
        PURCHASE,
        CANCELLATION
    }

    private Type type;
    private double amount;
    private String movieTitle;

    public Transaction(Type type, double amount, String movieTitle) {
        this.type = type;
        this.amount = amount;
        this.movieTitle = movieTitle;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}
