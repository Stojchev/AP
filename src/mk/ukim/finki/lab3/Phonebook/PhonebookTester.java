package mk.ukim.finki.lab3.Phonebook;

import java.util.*;

class InvalidNameException extends Exception {
    public String name = "Abraham";

    InvalidNameException() {
        this.name = "Abraham";
    }
}

class InvalidNumberException extends Exception {
    public InvalidNumberException() {
    }
}

class MaximumSizeExceddedException extends Exception {
    public MaximumSizeExceddedException() {
    }
}

class Contact {
    String name;
    ArrayList<String> numbers = new ArrayList<>();

    public Contact(String name, String... number) throws InvalidNameException {
        if (name.length() > 4 && name.length() <= 10 && name.matches("\\w+"))
            this.name = name;
        else throw new InvalidNameException();
        for (String s : number) {
            try {
                addNumber(s);
            } catch (MaximumSizeExceddedException | InvalidNumberException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[] getNumbers() {
        return numbers.stream().sorted().toArray(String[]::new);
    }

    public void addNumber(String number) throws MaximumSizeExceddedException, InvalidNumberException {
        if (number.length() == 9 && (number.substring(0, 3).equals("070") || number.substring(0, 3).equals("071") ||
                number.substring(0, 3).equals("072") || number.substring(0, 3).equals("075") ||
                number.substring(0, 3).equals("076") || number.substring(0, 3).equals("077") ||
                number.substring(0, 3).equals("078"))) {
            if (numbers.size() < 5)
                numbers.add(number);
            else throw new MaximumSizeExceddedException();
        } else throw new InvalidNumberException();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("\n");
        sb.append(this.numbers.size());
        sb.append("\n");
        for (String i : getNumbers()) {
            sb.append(i);
            sb.append("\n");
        }
        return sb.toString();
    }
}

class PhoneBook {

    Contact[] contacts;

    PhoneBook() {
        this.contacts = new Contact[0];
    }

    void addContact(Contact contact) throws Exception {
        if (contacts.length == 250) throw new MaximumSizeExceddedException();
        if (contactExists(contact.name)) throw new InvalidNameException();
        Contact[] temp = Arrays.copyOf(contacts, contacts.length + 1);
        temp[temp.length - 1] = contact;
        contacts = temp;
    }

    boolean contactExists(String contact) {
        return Arrays.stream(contacts).anyMatch(a -> a.name.equals(contact));
    }

    Contact getContactForName(String name) throws Exception {
        for (Contact contact1 : contacts)
            if (contact1.getName().equals(name))
                return contact1;
        return null;
    }

    int numberOfContacts() {
        return contacts.length;
    }

    Contact[] getContacts() {
        return Arrays.stream(contacts).sorted(Comparator.comparing(Contact::getName)).toArray(Contact[]::new);
    }

    void removeContact(String name) {
        if (contactExists(name)) {
            contacts = Arrays.stream(contacts).filter(a -> !a.getName().equals(name)).toArray(Contact[]::new);
        }
    }

    static void saveAsTextFile(PhoneBook phonebook, String path) {
    }

    static PhoneBook loadFromTextFile(String path) {
        return new PhoneBook();
    }

    Contact[] getContactsForNumber(String number_prefix) {
        return Arrays.stream(contacts)
                .filter(a -> Arrays.stream(a.getNumbers()).anyMatch(b -> b.startsWith(number_prefix))).toArray(Contact[]::new);
    }

    public String toString() {
        return Arrays.toString(contacts);
    }
}


public class PhonebookTester {

    public static void main(String[] args) throws Exception {
        Scanner jin = new Scanner(System.in);
        String line = jin.nextLine();
        switch (line) {
            case "test_contact":
                testContact(jin);
                break;
            case "test_phonebook_exceptions":
                testPhonebookExceptions(jin);
                break;
            case "test_usage":
                testUsage(jin);
                break;
        }
    }

    private static void testFile(Scanner jin) throws Exception {
        PhoneBook phonebook = new PhoneBook();
        while (jin.hasNextLine())
            phonebook.addContact(new Contact(jin.nextLine(), jin.nextLine().split("\\s++")));
        String text_file = "phonebook.txt";
        PhoneBook.saveAsTextFile(phonebook, text_file);
        PhoneBook pb = PhoneBook.loadFromTextFile(text_file);
        if (!pb.equals(phonebook)) System.out.println("Your file saving and loading doesn't seem to work right");
        else System.out.println("Your file saving and loading works great. Good job!");
    }

    private static void testUsage(Scanner jin) throws Exception {
        PhoneBook phonebook = new PhoneBook();
        while (jin.hasNextLine()) {
            String command = jin.nextLine();
            switch (command) {
                case "add":
                    phonebook.addContact(new Contact(jin.nextLine(), jin.nextLine().split("\\s++")));
                    break;
                case "remove":
                    phonebook.removeContact(jin.nextLine());
                    break;
                case "print":
                    System.out.println(phonebook.numberOfContacts());
                    System.out.println(Arrays.toString(phonebook.getContacts()));
                    System.out.println(phonebook.toString());
                    break;
                case "get_name":
                    System.out.println(phonebook.getContactForName(jin.nextLine()));
                    break;
                case "get_number":
                    System.out.println(Arrays.toString(phonebook.getContactsForNumber(jin.nextLine())));
                    break;
            }
        }
    }

    private static void testPhonebookExceptions(Scanner jin) {
        PhoneBook phonebook = new PhoneBook();
        boolean exception_thrown = false;
        try {
            while (jin.hasNextLine()) {
                phonebook.addContact(new Contact(jin.nextLine()));
            }
        } catch (InvalidNameException e) {
            System.out.println(e.name);
            exception_thrown = true;
        } catch (Exception e) {
        }
        if (!exception_thrown) System.out.println("Your addContact method doesn't throw InvalidNameException");
        /*
        exception_thrown = false;
        try {
        phonebook.addContact(new Contact(jin.nextLine()));
        } catch ( MaximumSizeExceddedException e ) {
            exception_thrown = true;
        }
        catch ( Exception e ) {}
        if ( ! exception_thrown ) System.out.println("Your addContact method doesn't throw MaximumSizeExcededException");
        */
    }

    private static void testContact(Scanner jin) throws Exception, InvalidNameException, InvalidNumberException, MaximumSizeExceddedException {
        boolean exception_thrown = true;
        String names_to_test[] = {"And\nrej", "asd", "AAAAAAAAAAAAAAAAAAAAAA", "Ð�Ð½Ð´Ñ€ÐµÑ˜A123213", "Andrej#", "Andrej<3"};
        for (String name : names_to_test) {
            new Contact(name);
            exception_thrown = false;
            if (!exception_thrown) System.out.println("Your Contact constructor doesn't throw an InvalidNameException");
        }
        String numbers_to_test[] = {"+071718028", "number", "078asdasdasd", "070asdqwe", "070a56798", "07045678a", "123456789", "074456798", "073456798", "079456798"};
        for (String number : numbers_to_test) {
            new Contact("Andrej", number);
            exception_thrown = false;
            if (!exception_thrown)
                System.out.println("Your Contact constructor doesn't throw an InvalidNumberException");
        }
        String nums[] = new String[10];
        for (int i = 0; i < nums.length; ++i) nums[i] = getRandomLegitNumber();
        new Contact("Andrej", nums);
        if (!exception_thrown)
            System.out.println("Your Contact constructor doesn't throw a MaximumSizeExceddedException");
        Random rnd = new Random(5);
        Contact contact = new Contact("Andrej", getRandomLegitNumber(rnd), getRandomLegitNumber(rnd), getRandomLegitNumber(rnd));
        System.out.println(contact.getName());
        System.out.println(Arrays.toString(contact.getNumbers()));
        System.out.println(contact.toString());
        contact.addNumber(getRandomLegitNumber(rnd));
        System.out.println(Arrays.toString(contact.getNumbers()));
        System.out.println(contact.toString());
        contact.addNumber(getRandomLegitNumber(rnd));
        System.out.println(Arrays.toString(contact.getNumbers()));
        System.out.println(contact.toString());
    }

    static String[] legit_prefixes = {"070", "071", "072", "075", "076", "077", "078"};
    static Random rnd = new Random();

    private static String getRandomLegitNumber() {
        return getRandomLegitNumber(rnd);
    }

    private static String getRandomLegitNumber(Random rnd) {
        StringBuilder sb = new StringBuilder(legit_prefixes[rnd.nextInt(legit_prefixes.length)]);
        for (int i = 3; i < 9; ++i)
            sb.append(rnd.nextInt(10));
        return sb.toString();
    }
}