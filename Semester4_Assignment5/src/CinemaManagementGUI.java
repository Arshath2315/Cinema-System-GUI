import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CinemaManagementGUI extends JFrame {

    private JButton btnReserveTicket;
    private  JButton btnCancelReservation;
    private JButton btnCheckRating;
    private JButton btnRecommendation;
    private JButton btnSalesReport;
    private JButton btnPurchaseTicket;
    private LoyaltyPointSystem loyaltyPoints;
    private EmployeeManager employeeManager;
    private User user;
    private JTextArea salesReportTextArea; // JTextArea to display sales report

    // list of available movies with genre and age
    private String[][] availableMovies = {
            {"King Kong", "Action", "13"},
            {"Spider-Man", "Action", "12"},
            {"Inception", "Sci-Fi", "15"},
            {"Psycho", "Horror", "18"},
            {"Lion King", "Animation", "0"}
    };

    // List to store reservations made by the user
    private List<String> userReservations;

    // Recommendation system instance
    private RecommendationSystem recommendationSystem;

    // 2D array to represent seat availability
    private boolean[][] seatMatrix;

    // Framework
    public CinemaManagementGUI() {
        setTitle("Cinema Management System");
        setSize(800, 600); // Increased size to accommodate seating section
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Initialize userReservations list
        userReservations = new ArrayList<>();

        // Set up a sample user for loyalty points
        user = new User("Dara", "", ""); // Initialize the class variable instead of a local variable

        // Initialize LoyaltyPointSystem with the user
        loyaltyPoints = new LoyaltyPointSystem();
        loyaltyPoints.addUser(user);

        // Initialize recommendation system
        recommendationSystem = RecommendationSystem.getInstance();
        // Add movies to recommendation system
        for (String[] movieInfo : availableMovies) {
            String title = movieInfo[0];
            String genre = movieInfo[1];
            int age = Integer.parseInt(movieInfo[2]);
            recommendationSystem.addMovie(new Movie(title, "Unknown", 0, genre, age));
        }

        // Initialize the seating section
        seatMatrix = new boolean[10][10]; // Adjust the size as needed

        initComponents();
        addComponentsToFrame();
        //displaySeatingSection(); // Display seating section initially
        employeeManager = new EmployeeManager();
    }

    private void initComponents() {
        // Creating buttons
        btnReserveTicket = new JButton("Reserve Ticket");
        btnCancelReservation = new JButton("Cancel Reservation");
        btnCheckRating = new JButton("Check Movie Rating");
        btnRecommendation = new JButton("Movie Recommendation"); // Fixed typo here
        btnSalesReport = new JButton("View Sales Report");
        btnPurchaseTicket = new JButton("Purchase Ticket");

        // Set preferred button size, adjust to what you'd like
        Dimension buttonSize = new Dimension(200, 40);
        btnReserveTicket.setPreferredSize(buttonSize);
        btnCancelReservation.setPreferredSize(buttonSize);
        btnCheckRating.setPreferredSize(buttonSize);
        btnRecommendation.setPreferredSize(buttonSize);
        btnSalesReport.setPreferredSize(buttonSize);
        btnPurchaseTicket.setPreferredSize(buttonSize);

        // Add action listeners
        btnReserveTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveTicket();
            }
        });

        btnCancelReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelReservation();
            }
        });

        btnCheckRating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkRating();
            }
        });

        btnRecommendation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recommendMovie();
            }
        });

        btnPurchaseTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchaseTicket();
            }
        });

        btnSalesReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaySalesReport(); // Call the method to display sales report
            }
        });

       //Initialize JTextArea for sales report
        salesReportTextArea = new JTextArea();
        salesReportTextArea.setEditable(false); // Make it non-editable

        // Set preferred size for the text area
        salesReportTextArea.setPreferredSize(new Dimension(200, 200)); // Adjust the dimensions as needed

        // Set font size for the text area
        Font font = salesReportTextArea.getFont();
        salesReportTextArea.setFont(new Font(font.getName(), Font.PLAIN, 14)); // Adjust the font size as needed
    }

    private void addComponentsToFrame() {
        // Add buttons to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        buttonPanel.add(btnReserveTicket);
        buttonPanel.add(btnCancelReservation);
        buttonPanel.add(btnCheckRating);
        buttonPanel.add(btnRecommendation);
        buttonPanel.add(btnSalesReport);
        buttonPanel.add(btnPurchaseTicket);

        add(buttonPanel, BorderLayout.CENTER);

        // Add JTextArea for sales report to the frame
        JScrollPane scrollPane = new JScrollPane(salesReportTextArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Sales Report"));
        add(scrollPane, BorderLayout.SOUTH);

        // Add loyalty panel to display loyalty points for the user
        JPanel loyaltyPanel = new JPanel();
        loyaltyPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        loyaltyPanel.add(new JLabel("Loyalty Points: " + loyaltyPoints.getPoints(user)));
        add(loyaltyPanel, BorderLayout.NORTH);
    }

    // LOGIC WHEN RESERVING A TICKET
    private void reserveTicket() {
        // Show dialog to select movie for reservation
        String[] movieTitles = new String[availableMovies.length];
        for (int i = 0; i < availableMovies.length; i++) {
            movieTitles[i] = availableMovies[i][0]; // Get movie titles only
        }

        String selectedMovie = (String) JOptionPane.showInputDialog(this,
                "Select a movie to reserve a ticket for:",
                "Reserve Ticket",
                JOptionPane.QUESTION_MESSAGE,
                null,
                movieTitles,
                movieTitles[0]);

        // If a movie is selected, show confirmation message and add reservation to userReservations
        if (selectedMovie != null) {
            userReservations.add(selectedMovie);
            JOptionPane.showMessageDialog(this, "Ticket for \"" + selectedMovie + "\" reserved successfully!");
            loyaltyPoints.addPoints(user, 1); // Update loyalty points
        }
    }

    // LOGIC FOR CANCEL RESERVATION
    private void cancelReservation() {
        // Convert userReservations list to array for display in the dialog
        String[] userReservationsArray = userReservations.toArray(new String[0]);

        // Show dialog to select reservation to cancel
        String selectedReservation = (String) JOptionPane.showInputDialog(this,
                "Select a reservation to cancel:",
                "Cancel Reservation",
                JOptionPane.QUESTION_MESSAGE,
                null,
                userReservationsArray,
                userReservationsArray[0]);

        // If a reservation is selected, remove it from userReservations list and show confirmation message
        if (selectedReservation != null) {
            userReservations.remove(selectedReservation);
            JOptionPane.showMessageDialog(this, "Reservation for \"" + selectedReservation + "\" canceled successfully!");
            loyaltyPoints.addPoints(user, -1); // Update loyalty points
        }
    }

    // LOGIC FOR RATING BUTTON
    private void checkRating() {
        // Show dialog to select movie to check rating
        String[] movieTitles = new String[availableMovies.length];
        for (int i = 0; i < availableMovies.length; i++) {
            movieTitles[i] = availableMovies[i][0]; // Get movie titles only
        }

        String selectedMovie = (String) JOptionPane.showInputDialog(this,
                "Select a movie to check the rating:",
                "Check Movie Rating",
                JOptionPane.QUESTION_MESSAGE,
                null,
                movieTitles,
                movieTitles[0]);

        // If a movie is selected, get and display its ratings
        if (selectedMovie != null) {
            // Retrieve the singleton instance of RatingManager
            RatingManager ratingManager = RatingManager.getInstance();
            List<Rating> ratings = ratingManager.getRatingsForMovie(selectedMovie);

            StringBuilder message = new StringBuilder("Ratings for \"" + selectedMovie + "\":\n");
            if (ratings.isEmpty()) {
                message.append("No ratings available for this movie.");
            } else {
                for (Rating rating : ratings) {
                    message.append("Rating: ").append(rating.getRating()).append("\n");
                    message.append("Comment: ").append(rating.getComment()).append("\n");
                    message.append("\n");
                }
            }
            JOptionPane.showMessageDialog(this, message.toString());
        }
    }

    //LOGIC FOR RECOMMENDMOVIE
    private void recommendMovie() {
        System.out.println("recommendMovie() method called."); // Debug statement
        String[] movieTitles = new String[availableMovies.length];
        for (int i = 0; i < availableMovies.length; i++) {
            movieTitles[i] = availableMovies[i][0]; // Get movie titles only
        }

        String selectedMovieTitle = (String) JOptionPane.showInputDialog(this,
                "Select a movie to get recommendations:",
                "Movie Recommendation",
                JOptionPane.QUESTION_MESSAGE,
                null,
                movieTitles,
                movieTitles[0]);

        if (selectedMovieTitle != null) {
            // Find the selected movie in the recommendation system
            Movie selectedMovie = recommendationSystem.getMovieByTitle(selectedMovieTitle);

            if (selectedMovie != null) {
                List<Movie> recommendations = recommendationSystem.recommendMovies(selectedMovie);

                if (recommendations.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No recommended movies found.");
                } else {
                    StringBuilder message = new StringBuilder("Recommended Movies for \"" + selectedMovie.getTitle() + "\":\n");
                    for (Movie movie : recommendations) {
                        message.append("Title: ").append(movie.getTitle()).append("\n");
                        message.append("Genre: ").append(movie.getGenre()).append("\n");
                        message.append("Age Group: ").append(getAgeGroup(movie.getAge())).append("\n");
                        // Add more information as needed
                        message.append("\n");
                    }
                    JOptionPane.showMessageDialog(this, message.toString());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selected movie not found in the recommendation system.");
            }
        }
    }

    //LOGIC FOR PURCHASING A TICKET
    private void purchaseTicket() {
        // Check if the user has loyalty points
        if (loyaltyPoints.getPoints(user) >= 0) {
            // Show dialog to select movie for ticket purchase
            String[] movieTitles = new String[availableMovies.length];
            for (int i = 0; i < availableMovies.length; i++) {
                movieTitles[i] = availableMovies[i][0]; // Get movie titles only
            }

            String selectedMovie = (String) JOptionPane.showInputDialog(this,
                    "Select a movie to purchase a ticket for:",
                    "Purchase Ticket",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    movieTitles,
                    movieTitles[0]);

            // If a movie is selected, proceed with ticket purchase
            if (selectedMovie != null) {
                // Display available seats counter
                int availableSeats = countAvailableSeats(); // Implement countAvailableSeats method
                CinemaHall cinemaHall = new CinemaHall(1,100,10,10);
                int y = cinemaHall.getSeatingCapacity();
                int x = countAvailableSeats();
                JOptionPane.showMessageDialog(this, "Available Seats: " + (y-x));

                // Ask user if they want to use loyalty points for a discount
                int choice = JOptionPane.showConfirmDialog(this, "Do you want to use your loyalty points for a discount?", "Use Loyalty Points", JOptionPane.YES_NO_OPTION);
                boolean useLoyaltyPoints = (choice == JOptionPane.YES_OPTION);

                // Show dialog to input number of points to spend (if using loyalty points)
                int pointsToSpend = 0;
                if (useLoyaltyPoints) {
                    // Check if the user has loyalty points
                    if (loyaltyPoints.getPoints(user) > 0)
                    {
                        String pointsToSpendStr = JOptionPane.showInputDialog(this,
                                "Enter the number of loyalty points you want to spend (0-" + loyaltyPoints.getPoints(user) + "):",
                                "Points to Spend",
                                JOptionPane.QUESTION_MESSAGE);

                        // Parse the input for points to spend
                        try {
                            pointsToSpend = Integer.parseInt(pointsToSpendStr);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number of points.");
                            return; // Return if input is invalid
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "You don't have any loyalty points to use for a discount.");
                    }

                }
                // Calculate the discounted price using loyalty points
                double ticketPrice = 10.0; // Example ticket price, replace with actual logic to get ticket price
                double discountedPrice = useLoyaltyPoints ? loyaltyPoints.purchaseTicket(user, ticketPrice, pointsToSpend) : ticketPrice;

                // Show confirmation message with the discounted price
                JOptionPane.showMessageDialog(this, "Ticket for \"" + selectedMovie + "\" purchased successfully!\nDiscounted Price: $" + discountedPrice);
                loyaltyPoints.addPoints(user, +1);
            }
        }
    }

    private void displaySalesReport() {
        // Clear the sales report text area before displaying new data
        salesReportTextArea.setText("");

        // Add sample employees (you can replace this with your actual employee data)
        employeeManager.addEmployee("1", "King Charles", "charles@gmail.com");
        employeeManager.addEmployee("2", "Mary Jane", "jane@gmail.com");

        // Record sample sales (you can replace this with your actual sales data)
        employeeManager.recordSale("1", 150.0, "King Kong", Transaction.Type.PURCHASE);
        employeeManager.recordSale("2", 200.0, "Spider-Man", Transaction.Type.PURCHASE);
        employeeManager.recordSale("2", 300.0, "Psycho", Transaction.Type.PURCHASE);

        // Record sample cancellations (you can replace this with your actual cancellation data)
        employeeManager.recordSale("1", 50.0, "Inception", Transaction.Type.CANCELLATION);

        // Display sales report in the JTextArea
        salesReportTextArea.append("Employee Sales Report:\n");
        for (Employee employee : employeeManager.getEmployees().values()) {
            salesReportTextArea.append("Employee ID: " + employee.getId() + "\n");
            salesReportTextArea.append("Employee Name: " + employee.getName() + "\n");
            salesReportTextArea.append("Employee Email: " + employee.getEmail() + "\n");
            salesReportTextArea.append("Total Sales: $" + employee.getTotalSales() + "\n\n");
        }
    }

    // Method to count available seats (example implementation)
    private int countAvailableSeats() {
        // Example implementation - replace with actual logic to count available seats
        int totalSeats = 100; // Total seats in the cinema hall
        int reservedSeats = 20; // Number of reserved seats
        return totalSeats - reservedSeats;
    }

    private String getAgeGroup(int age) {
        if (age <= 12) {
            return "Child";
        } else if (age <= 18) {
            return "Teenager";
        } else {
            return "Adult";
        }
    }

    public static void main(String[] args) {
        // Ensure Swing components are created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CinemaManagementGUI().setVisible(true);
            }
        });
    }
}
