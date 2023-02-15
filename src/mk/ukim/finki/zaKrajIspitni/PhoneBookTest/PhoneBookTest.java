package mk.ukim.finki.zaKrajIspitni.PhoneBookTest;


import java.util.*;
import java.util.stream.Collectors;


class Contact implements Comparable<Contact> {
    String name;
    String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, number);
    }


    @Override
    public int compareTo(Contact o) {
        return name.toLowerCase().compareTo(o.name.toLowerCase());
    }
}

class DuplicateNumberException extends Exception {
    public DuplicateNumberException(String number) {
        super(String.format("Duplicate number: %s", number));
    }
}

class PhoneBook {
    Map<String, Set<Contact>> contacts;

    public PhoneBook() {
        this.contacts = new TreeMap<>();
    }

    public void addContact(String name, String number) throws DuplicateNumberException {
        if (contacts.containsKey(number))
            throw new DuplicateNumberException(number);
        contacts.putIfAbsent(name, new TreeSet<>(Comparator.comparing(Contact::getNumber)));
        contacts.get(name).add(new Contact(name, number));
    }

    public void contactsByNumber(String number) {
        StringBuilder sb = new StringBuilder();
        contacts.values().forEach(i -> i.stream().filter(j -> j.getNumber().contains(number)).forEach(k -> sb.append(k).append("\n")));
        if (sb.length() == 0)
            System.out.println("NOT FOUND");
        else System.out.print(sb);
    }

    public void contactsByName(String name) {
        StringBuilder sb = new StringBuilder();
        if (!contacts.containsKey(name))
            System.out.println("NOT FOUND");
        else {
            contacts.get(name).stream().collect(Collectors.toList()).forEach(i -> sb.append(i).append("\n"));
            System.out.print(sb);
        }
    }
}


public class PhoneBookTest {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            try {
                phoneBook.addContact(parts[0], parts[1]);
            } catch (DuplicateNumberException e) {
                System.out.println(e.getMessage());
            }
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] parts = line.split(":");
            if (parts[0].equals("NUM")) {
                phoneBook.contactsByNumber(parts[1]);
            } else {
                phoneBook.contactsByName(parts[1]);
            }
        }
    }

}

// Вашиот код овде

