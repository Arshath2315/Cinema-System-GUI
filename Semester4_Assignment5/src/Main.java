import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CinemaManagementGUI gui = new CinemaManagementGUI();
                gui.setVisible(true);
            }
        });
    }
    }

//        RatingManager ratingManager = new RatingManager();
//        ReservationManager reservationManager = new ReservationManager();
//
//        // Add ratings for movies
//        Movie movie1 = new Movie("Movie 1", "Description 1", 120, "Action", 10);
//        Movie movie2 = new Movie("Movie 2", "Description 2", 110, "Action", 12);
//        Movie movie3 = new Movie("Movie 3", "Description 3", 100, "Drama", 18);
//
//        ratingManager.addRating(movie1, 4.5, "Great movie!");
//        ratingManager.addRating(movie1, 3.5, "Good but could be better");
//        ratingManager.addRating(movie2, 4.0, "Hilarious!");
//
//        System.out.println("--------------RATING------------------");
//        // Retrieve and display ratings for movies
//        System.out.println("Ratings for Movie 1:");
//        for (Rating rating : ratingManager.getRatingsForMovie(movie1)) {
//            System.out.println(rating.getRating() + " - " + rating.getComment());
//        }
//
//        System.out.println("Ratings for Movie 2:");
//        for (Rating rating : ratingManager.getRatingsForMovie(movie2)) {
//            System.out.println(rating.getRating() + " - " + rating.getComment());
//        }
//
//        // Make reservations and cancel the latest reservation
//        Reservation reservation1 = new Reservation(new Showtime(movie1, "12:00", "14:00", new CinemaHall(1, 100,6,6)), new User("user1", "password1", "user1@example.com"), 2);
//        Reservation reservation2 = new Reservation(new Showtime(movie2, "15:00", "17:00", new CinemaHall(2, 150,6,6)), new User("user2", "password2", "user2@example.com"), 3);
//
//        reservationManager.makeReservation(reservation1);
//        reservationManager.makeReservation(reservation2);
//
//        System.out.println("---------------------------------");
//
//        reservationManager.displayReservation(reservation1);
//        reservationManager.displayReservation(reservation2);
//
//        System.out.println("---------------------------------");
//
//        System.out.println("Latest Reservation Cancelled: " + reservationManager.cancelLatestReservation());
//        System.out.println("Latest Reservation Cancelled: " + reservationManager.cancelLatestReservation());
//
//        System.out.println("--------------RECOMMENDATIONS------------------");
//        RecommendationSystem recommendationSystem = new RecommendationSystem();
//
//        // Add movies to the recommendation system
//        recommendationSystem.addMovie(movie1);
//        recommendationSystem.addMovie(movie2);
//        recommendationSystem.addMovie(movie3);
//
//        // Recommend movies based on a given movie's genre and suitable age
//        List<Movie> recommendedMovies = recommendationSystem.recommendMovies(movie1);
//        System.out.println("Recommended movies for Movie 1:");
//        for (Movie recommendedMovie : recommendedMovies) {
//            System.out.println(recommendedMovie.getTitle());
//        }
//
//        System.out.println("--------------EMPLOYEES------------------");
//        EmployeeManager employeeManager = new EmployeeManager();
//
//        employeeManager.addEmployee("001", "John Doe", "john.doe@example.com");
//        employeeManager.addEmployee("002", "Jane Smith", "jane.smith@example.com");
//
//        employeeManager.recordSale("001", 100.0);
//        employeeManager.recordSale("001", 150.0);
//        employeeManager.recordSale("002", 200.0);
//
//        employeeManager.displaySalesReport();
//
//        System.out.println("--------------DISCOUNT & LOYALTY POINTS------------------");
//        CinemaTicketReservationSystem system = new CinemaTicketReservationSystem();
//
//        User user1 = new User("user1", "password1", "user1@example.com");
//
//        system.addUser(user1);
//        system.addPoints(user1, 100); // User has 100 loyalty points
//
//        //System.out.println(system.getPoints(user1));
//
//        double ticketPrice = 50.0;
//        int pointsToSpend = 100; // User wants to spend 50 loyalty points
//        double discountedPrice = system.purchaseTicket(user1, ticketPrice, pointsToSpend);
//
//        System.out.println("Ticket Price: $" + ticketPrice);
//        System.out.println("Discounted Price: $" + discountedPrice);
//        System.out.println("Remaining Loyalty Points: " + system.getPoints(user1));
//
//        System.out.println("\n--------------SEATING/CINEMAHALL------------------");
//        CinemaHall hall = new CinemaHall(1, 100, 5, 10); // Hall 1, seating capacity 100, 5 rows, 10 columns
//
//        // Reserve some seats
//        if (hall.reserveSeat(0, 0)) {
//            System.out.println("Seat at row 0, col 0 reserved.");
//        } else {
//            System.out.println("Seat at row 0, col 0 already reserved or invalid.");
//        }
//
//        if (hall.reserveSeat(2, 5)) {
//            System.out.println("Seat at row 2, col 5 reserved.");
//        } else {
//            System.out.println("Seat at row 2, col 5 already reserved or invalid.");
//        }
//
//        if (hall.reserveSeat(4, 9)) {
//            System.out.println("Seat at row 4, col 9 reserved.");
//        } else {
//            System.out.println("Seat at row 4, col 9 already reserved or invalid.");
//        }
//
//        // Display the seat map
//        hall.displaySeats();
//    }
