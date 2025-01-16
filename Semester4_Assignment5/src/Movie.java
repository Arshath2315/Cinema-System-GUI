import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String title;
    private String description;
    private int durationMinutes;
    private String genre;
    private double rating;
    private int age;
    private String ageGroup; // New field for age group
    private List<String> comments;

    public Movie(String title, String description, int durationMinutes, String genre, int age) {
        this.title = title;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.genre = genre;
        this.age = age;
        this.rating = 0.0;
        this.comments = new ArrayList<>();
        this.ageGroup = calculateAgeGroup(age); // Calculate age group based on age
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        // Update age group whenever age is changed
        this.ageGroup = calculateAgeGroup(age);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    // Method to calculate age group based on age
    private String calculateAgeGroup(int age) {
        if (age <= 12) {
            return "Child";
        } else if (age <= 18) {
            return "Teenager";
        } else {
            return "Adult";
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                ", ageGroup='" + ageGroup + '\'' +
                ", rating=" + rating +
                '}';
    }
}
