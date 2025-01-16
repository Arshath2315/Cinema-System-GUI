import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingManager {
    private static RatingManager instance;
    private Map<Movie, List<Rating>> ratingsMap;

    protected RatingManager() {
        ratingsMap = new HashMap<>();
        // Add ratings in the constructor
        // King Kong
        Movie kingKong = new Movie("King Kong", "Giant ape wreaks havoc in New York City", 120, "Action", 12);
        Rating kingKongRating = new Rating(kingKong, 4.5, "An amazing movie, loved it!");
        addRating(kingKongRating);
    }

    public static RatingManager getInstance() {
        if (instance == null) {
            instance = new RatingManager();
        }
        return instance;
    }

    public void addRating(Rating rating) {
        Movie movie = rating.getMovie();
        List<Rating> ratings = ratingsMap.getOrDefault(movie, new ArrayList<>());
        ratings.add(rating);
        ratingsMap.put(movie, ratings);
    }

    public List<Rating> getRatingsForMovie(String movieName) {
        List<Rating> movieRatings = new ArrayList<>();
        for (Map.Entry<Movie, List<Rating>> entry : ratingsMap.entrySet()) {
            if (entry.getKey().getTitle().equals(movieName)) {
                movieRatings.addAll(entry.getValue());
            }
        }
        return movieRatings;
    }
}
