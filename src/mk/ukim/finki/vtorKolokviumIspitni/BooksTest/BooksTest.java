package mk.ukim.finki.vtorKolokviumIspitni.BooksTest;

import java.util.*;
import java.util.stream.Collectors;

class Book implements Comparable<Book>{
    String title;
    String category;
    float price;

    public Book(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getTitleWithLowerCase() {
        return title.toLowerCase();
    }

    public String getCategoryWithLowerCase() {
        return category.toLowerCase();
    }


    public float getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) %.2f", title, category, price);
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Book o2) {
        if(title.equalsIgnoreCase(o2.title))
            return Float.compare(price,o2.price);
        return title.compareTo(o2.title);
    }
}

class BookCollection {
    Set<Book> bookSet;

    public BookCollection() {
        this.bookSet = new HashSet<>();
    }

    public void addBook(Book book) {
        bookSet.add(book);
    }

    public void printByCategory(String category) {
        Comparator<Book> comparator = Comparator.comparing(Book::getTitleWithLowerCase).thenComparing(Book::getPrice);
        bookSet.stream().filter(i->i.getCategoryWithLowerCase().equals(category.toLowerCase())).sorted(comparator).forEach(i -> System.out.println(i.toString()));
    }

    public List<Book> getCheapestN(int n) {
        return bookSet.stream().sorted(Comparator.comparing(Book::getPrice)).limit(n).collect(Collectors.toList());
    }
}

public class BooksTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        BookCollection booksCollection = new BookCollection();
        Set<String> categories = fillCollection(scanner, booksCollection);
        System.out.println("=== PRINT BY CATEGORY ===");
        for (String category : categories) {
            System.out.println("CATEGORY: " + category);
            booksCollection.printByCategory(category);
        }
        System.out.println("=== TOP N BY PRICE ===");
        print(booksCollection.getCheapestN(n));
    }

    static void print(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    static TreeSet<String> fillCollection(Scanner scanner,
                                          BookCollection collection) {
        TreeSet<String> categories = new TreeSet<String>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            Book book = new Book(parts[0], parts[1], Float.parseFloat(parts[2]));
            collection.addBook(book);
            categories.add(parts[1]);
        }
        return categories;
    }
}

// Вашиот код овде