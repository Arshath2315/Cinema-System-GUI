import java.util.*;

public class RecommendationSystem {
    private static RecommendationSystem instance;
    private Map<String, List<Movie>> genreMap;
    private Random random;

    private RecommendationSystem() {
        genreMap = new HashMap<>();
        random = new Random(); // Initialize Random object
    }

    public static RecommendationSystem getInstance() {
        if (instance == null) {
            instance = new RecommendationSystem();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        String genre = movie.getGenre();
        List<Movie> movies = genreMap.getOrDefault(genre, new ArrayList<>());
        movies.add(movie);
        genreMap.put(genre, movies);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return genreMap.getOrDefault(genre, new ArrayList<>());
    }

    public List<Movie> recommendMovies(Movie movie) {
        List<Movie> recommendedMovies = new ArrayList<>();
        String genre = movie.getGenre();
        int age = movie.getAge();

        // Get movies of the same genre
        List<Movie> genreMovies = getMoviesByGenre(genre);

        // Add movies of the same genre to the recommended list
        for (Movie genreMovie : genreMovies) {
            // Generate a random age between 1 and 18 for each movie
            int randomAge = random.nextInt(18) + 1;
            genreMovie.setAge(randomAge); // Set the random age to the movie
            if (!genreMovie.equals(movie) && genreMovie.getAge() <= age) {
                recommendedMovies.add(genreMovie);
            }
        }

        return recommendedMovies;
    }

    public Movie getMovieByTitle(String title) {
        for (List<Movie> movies : genreMap.values()) {
            for (Movie movie : movies) {
                if (movie.getTitle().equals(title)) {
                    return movie;
                }
            }
        }
        return null; // Return null if movie not found
    }


}
