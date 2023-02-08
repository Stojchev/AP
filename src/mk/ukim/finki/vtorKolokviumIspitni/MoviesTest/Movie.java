package mk.ukim.finki.vtorKolokviumIspitni.MoviesTest;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//public class Movie {
//    String name;
//    List<Integer> ratings;
//    int countAllRatings;
//    public Movie(String name, int[] ratings) {
//        this.name = name;
//        this.ratings = IntStream.range(0, ratings.length)
//                .mapToObj(i -> ratings[i]).collect(Collectors.toList());
//        this.countAllRatings=0;
//    }
//
//    public int getCountAllRatings() {
//        return countAllRatings;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setCountAllRatings(int n){
//        this.countAllRatings=n;
//    }
//
//    public double averageRating() {
//        double sum = 0;
//
//        for (Integer rating : ratings) sum += rating;
//
//        return sum / ratings.size();
//    }
//
//    public List<Integer> getRatings() {
//        return ratings;
//    }
//
//    public int getTotal() {
//        int sum = 0;
//        for (Integer rating : ratings) sum += rating;
//        return sum;
//    }
//    public double coefRating(int max){
//        return averageRating()*getTotal()/getCountAllRatings();
//    }
//    @Override
//    public String toString() {
//        return String.format("%s (%.2f) of %d ratings", name, averageRating(), ratings.size());
//    }
//
//}
