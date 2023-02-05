package mk.ukim.finki.vtorKolokviumIspitni.BooksTest;

import java.util.*;
import java.util.stream.Collectors;

//public class BookCollection {
//    Set<Book> bookSet;
//
//    public BookCollection() {
//        this.bookSet = new HashSet<>();
//    }
//
//    public void addBook(Book book) {
//        bookSet.add(book);
//    }
//
//    public void printByCategory(String category) {
//        Comparator<Book> comparator = Comparator.comparing(Book::getCategoryWithLowerCase).thenComparing(Book::getTitleWithLowerCase);
//        bookSet.stream().sorted(comparator).forEach(i -> System.out.println(i.toString()));
//    }
//
//    public List<Book> getCheapestN(int n) {
//        return bookSet.stream().sorted(Comparator.comparing(Book::getPrice)).limit(n).collect(Collectors.toList());
//    }
//}
