import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Reservation {
    private Showtime showtime;
    private User user;
    private int seatsReserved;
    private boolean isConfirmed;
    private Employee employee; // New field

    public Reservation(Showtime showtime, User user, int seatsReserved) {
        this.showtime = showtime;
        this.user = user;
        this.seatsReserved = seatsReserved;
        this.isConfirmed = false;
    }

    public Reservation() {

    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(int seatsReserved) {
        this.seatsReserved = seatsReserved;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "showtime=" + showtime.getMovie().getTitle() +
                ", user=" + user.getUsername() +
                ", seatsReserved=" + seatsReserved +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
