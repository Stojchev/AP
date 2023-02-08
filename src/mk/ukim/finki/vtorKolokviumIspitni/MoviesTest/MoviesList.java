package mk.ukim.finki.vtorKolokviumIspitni.MoviesTest;

import java.util.*;
import java.util.stream.Collectors;

//public class MoviesList {
//
//    List<Movie> movies;
//    int countAllRatings;
//
//    public MoviesList() {
//        this.movies = new ArrayList<>();
//        this.countAllRatings=0;
//    }
//
//    public void addMovie(String title, int[] ratings) {
//        this.movies.add(new Movie(title, ratings));
//        countAllRatings+=ratings.length;
//    }
//
//
//    public List<Movie> top10ByAvgRating() {
//        return movies.stream().collect(Collectors.toList()).stream().sorted(Comparator.comparing(Movie::averageRating).reversed()).collect(Collectors.toList()).subList(0, 10);
//    }
//    public List<Movie> top10ByRatingCoef(){
//        int max = movies.stream()
//                .mapToInt(movie -> movie.getRatings().size())
//                .max().getAsInt();
//
//        Comparator<Movie> comparator = (o1, o2) -> {
//            double first = o1.averageRating() * o1.getRatings().size() / max;
//            double second = o2.averageRating() * o2.getRatings().size() / max;
//
//            if(Double.compare(second, first) == 0)
//                return o1.getName().compareTo(o2.getName());
//
//            return Double.compare(second, first);
//        };
//
//        List<Movie> list = movies.stream()
//                .sorted(comparator)
//                .limit(10)
//                .collect(Collectors.toList());
//
//        return list;
//    }
//}
