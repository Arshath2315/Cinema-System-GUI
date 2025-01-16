public class Rating {

    private Movie movie;
    private double rating;
    private String comment;

    public Rating(Movie movie, double rating, String comment) {
        this.movie = movie;
        this.rating = rating;
        this.comment = comment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return null;
    };

}
