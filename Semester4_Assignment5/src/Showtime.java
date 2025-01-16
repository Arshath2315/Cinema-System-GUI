import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Showtime {
    private Movie movie;
    private String startTime;
    private String endTime;
    private CinemaHall cinemaHall;

    public Showtime(Movie movie, String startTime, String endTime, CinemaHall cinemaHall) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cinemaHall = cinemaHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "movie=" + movie.getTitle() +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cinemaHall=" + cinemaHall.getHallNumber() +
                '}';
    }
}