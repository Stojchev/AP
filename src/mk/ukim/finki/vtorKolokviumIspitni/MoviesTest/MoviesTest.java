package mk.ukim.finki.vtorKolokviumIspitni.MoviesTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Movie {
    String name;
    List<Integer> ratings;
    int countAllRatings;

    public Movie(String name, int[] ratings) {
        this.name = name;
        this.ratings = IntStream.range(0, ratings.length)
                .mapToObj(i -> ratings[i]).collect(Collectors.toList());
        this.countAllRatings = 0;
    }

    public int getCountAllRatings() {
        return countAllRatings;
    }

    public String getName() {
        return name;
    }

    public void setCountAllRatings(int n) {
        this.countAllRatings = n;
    }

    public double averageRating() {
        double sum = 0;

        for (Integer rating : ratings) sum += rating;

        return sum / ratings.size();
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public int getTotal() {
        int sum = 0;
        for (Integer rating : ratings) sum += rating;
        return sum;
    }

    public double coefRating(int max) {
        return averageRating() * getTotal() / getCountAllRatings();
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f) of %d ratings", name, averageRating(), ratings.size());
    }

}

class MoviesList {

    List<Movie> movies;

    public MoviesList() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(String title, int[] ratings) {
        this.movies.add(new Movie(title, ratings));
    }


    public List<Movie> top10ByAvgRating() {
        return movies.stream().collect(Collectors.toList()).stream().sorted(Comparator.comparing(Movie::averageRating).reversed().thenComparing(Movie::getName)).collect(Collectors.toList()).subList(0, 10);
    }

    public List<Movie> top10ByRatingCoef() {
        int max = movies.stream()
                .mapToInt(movie -> movie.getRatings().size())
                .max().getAsInt();

        Comparator<Movie> comparator = (o1, o2) -> {
            double first = o1.getCountAllRatings() * o1.averageRating() / max;
            double second = o2.getCountAllRatings() * o2.averageRating() / max;
            if (Double.compare(second, first) == 0)
                return o1.getName().compareTo(o2.getName());
            return Double.compare(second, first);
        };
        return movies.stream().sorted(comparator).limit(10).collect(Collectors.toList());
    }
}

public class MoviesTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MoviesList moviesList = new MoviesList();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String title = scanner.nextLine();
            int x = scanner.nextInt();
            int[] ratings = new int[x];
            for (int j = 0; j < x; ++j) {
                ratings[j] = scanner.nextInt();
            }
            scanner.nextLine();
            moviesList.addMovie(title, ratings);
        }
        scanner.close();
        List<Movie> movies = moviesList.top10ByAvgRating();
        System.out.println("=== TOP 10 BY AVERAGE RATING ===");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        movies = moviesList.top10ByRatingCoef();
        System.out.println("=== TOP 10 BY RATING COEFFICIENT ===");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}


// vashiot kod ovde