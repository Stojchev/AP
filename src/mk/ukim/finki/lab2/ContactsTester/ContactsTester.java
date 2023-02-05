package mk.ukim.finki.lab2.ContactsTester;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

class Faculty {
    String name;
    Student[] students;

    public Faculty(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    int countStudentsFromCity(String cityName) {
        int count = 0;
        for (Student student : students) {
            if (student.getCity().equals(cityName))
                count++;
        }
        return count;
    }

    Student getStudent(long index) {
        for (Student student : students)
            if (student.getIndex() == index)
                return student;
        return null;
    }

    double getAverageNumberOfContacts() {
        int vkupenbrStudenti = students.length;
        int brojkontakti = 0;
        for (Student student : students) {
            brojkontakti += student.getEmailContactNumber() + student.getPhoneContactNumber();
        }
        return (float) brojkontakti / vkupenbrStudenti;
    }

    Student getStudentWithMostContacts() {
        int max = 0;
        for (int i = 1; i < students.length; i++) {
            if (students[max].contacts.length < students[i].contacts.length)
                max = i;
            else if (students[max].contacts.length == students[i].contacts.length) {
                if (students[max].index < students[i].index)
                    max = i;
            }
        }
        return students[max];
    }

    @Override
    public String toString() {
        return "{" +
                "'fakultet:'" + name + '\'' +
                ", studenti=" + Arrays.toString(students) +
                '}';
    }
}

class Student {
    String FirstName;
    String LastName;
    String city;
    int age;
    long index;
    Contact[] contacts;

    public Student(String firstName, String lastName, String city, int age, long index) {
        FirstName = firstName;
        LastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
        contacts = new Contact[0];
    }

    void addEmailContact(String date, String email) {
        Contact[] pom = new Contact[contacts.length + 1];
        System.arraycopy(contacts, 0, pom, 0, contacts.length);
        Contact c = new EmailContact(date, email);
        contacts = pom;
        contacts[contacts.length - 1] = c;
    }

    void addPhoneContact(String date, String phone) {
        Contact[] pom = new Contact[contacts.length + 1];
        System.arraycopy(contacts, 0, pom, 0, contacts.length);
        Contact c = new PhoneContact(date, phone);
        contacts = pom;
        contacts[contacts.length - 1] = c;
    }

    Contact[] getEmailContacts() {
        int count = getEmailContactNumber();
        Contact[] contactEmail = new Contact[count];
        count = 0;
        for (Contact contact : contacts) {
            if (contact.getType().equals("Email"))
                contactEmail[count++] = contact;
        }
        return contactEmail;
    }

    int getEmailContactNumber() {
        int count = 0;
        for (Contact contact : contacts) {
            if (contact.getType().equals("Email"))
                count++;
        }
        return count;
    }

    int getPhoneContactNumber() {
        int count = 0;
        for (Contact contact : contacts) {
            if (contact.getType().equals("Phone"))
                count++;
        }
        return count;
    }

    Contact[] getPhoneContacts() {
        int count = getPhoneContactNumber();
        Contact[] contactPhone = new Contact[count];
        count = 0;
        for (Contact contact : contacts) {
            if (contact.getType().equals("Phone"))
                contactPhone[count++] = contact;
        }
        return contactPhone;
    }

    public String getCity() {
        return city;
    }

//    public String getFullName() {
//        return FirstName + " " + LastName;
//    }

    Contact getLatestContact() {
        Contact latest = contacts[0];
        for (Contact contact : contacts) {
            if (contact.isNewerThan(latest))
                latest = contact;
        }
        if (latest.getType().equals("Email"))
            latest = new EmailContact((EmailContact) latest);
        else latest = new PhoneContact((PhoneContact) latest);
        return latest;
    }

    public long getIndex() {
        return index;
    }

    @Override
    public String toString() {
        Contact[] pc = getPhoneContacts();
        Contact[] ec = getEmailContacts();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"ime\":");
        stringBuilder.append(FirstName);
        stringBuilder.append("', 'prezime:");
        stringBuilder.append(LastName);
        stringBuilder.append("', vozrast':");
        stringBuilder.append(age);
        stringBuilder.append(", 'grad':");
        stringBuilder.append(city);
        stringBuilder.append("', 'indeks':");
        stringBuilder.append(index);
        stringBuilder.append("\n'telefonskiKontakti':[");
        for (Contact contact : pc) {
            stringBuilder.append(contact.toString());
        }
        stringBuilder.append("emailKontakti");
        for (Contact contact : ec) {
            stringBuilder.append(contact.toString());
        }

        return stringBuilder.toString();
    }
}

class PhoneContact extends Contact {

    Operator operator;
    String phoneNumber;

    public PhoneContact(String date, String phoneNumber) {
        super(date);
        this.phoneNumber = phoneNumber;
        switch (phoneNumber.charAt(2)) {
            case '0':
            case '1':
            case '2':
                operator = Operator.TMOBILE;
                break;
            case '5':
            case '6':
                operator = Operator.ONE;
                break;
            case '7':
            case '8':
                operator = Operator.VIP;
                break;
            default:
                break;

        }
    }

    public PhoneContact(PhoneContact latest) {
        super(latest);
        phoneNumber = latest.phoneNumber;
        this.operator = latest.operator;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public String getType() {
        return "Phone";
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}

class EmailContact extends Contact {

    String email;

    public EmailContact(String date, String email) {
        super(date);
        this.email = email;
    }

    public EmailContact(EmailContact latest) {
        super(latest);
        email = latest.email;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String getType() {
        return "Email";
    }

    @Override
    public String toString() {
        return email;
    }
}

enum Operator {
    VIP,
    ONE,
    TMOBILE
}

abstract class Contact {

    protected int day;
    protected int month;
    protected int year;

    Contact(String date) {
        String[] dateSplit = date.split("-");
        year = Integer.parseInt(dateSplit[0]);
        month = Integer.parseInt(dateSplit[1]);
        day = Integer.parseInt(dateSplit[2]);
    }

    public Contact(Contact c) {
        day = c.day;
        month = c.month;
        year = c.year;
    }

    public abstract String getType();

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isNewerThan(Contact c) {
        if (year > c.getYear())
            return true;
        if (year == c.getYear() && month > c.getMonth())
            return true;
        return year == c.getYear() && month == c.getMonth() && day > c.getDay();
    }
}

public class ContactsTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        Faculty faculty = null;

        int rvalue = 0;
        long rindex = -1;

        DecimalFormat df = new DecimalFormat("0.00");

        for (int t = 0; t < tests; t++) {

            rvalue++;
            String operation = scanner.next();

            switch (operation) {
                case "CREATE_FACULTY": {
                    String name = scanner.nextLine().trim();
                    int N = scanner.nextInt();

                    Student[] students = new Student[N];

                    for (int i = 0; i < N; i++) {
                        rvalue++;

                        String firstName = scanner.next();
                        String lastName = scanner.next();
                        String city = scanner.next();
                        int age = scanner.nextInt();
                        long index = scanner.nextLong();

                        if ((rindex == -1) || (rvalue % 13 == 0))
                            rindex = index;

                        Student student = new Student(firstName, lastName, city,
                                age, index);
                        students[i] = student;
                    }

                    faculty = new Faculty(name, students);
                    break;
                }

                case "ADD_EMAIL_CONTACT": {
                    long index = scanner.nextInt();
                    String date = scanner.next();
                    String email = scanner.next();

                    rvalue++;

                    if ((rindex == -1) || (rvalue % 3 == 0))
                        rindex = index;

                    faculty.getStudent(index).addEmailContact(date, email);
                    break;
                }

                case "ADD_PHONE_CONTACT": {
                    long index = scanner.nextInt();
                    String date = scanner.next();
                    String phone = scanner.next();

                    rvalue++;

                    if ((rindex == -1) || (rvalue % 3 == 0))
                        rindex = index;

                    faculty.getStudent(index).addPhoneContact(date, phone);
                    break;
                }

                case "CHECK_SIMPLE": {
                    System.out.println("Average number of contacts: "
                            + df.format(faculty.getAverageNumberOfContacts()));

                    rvalue++;

                    String city = faculty.getStudent(rindex).getCity();
                    System.out.println("Number of students from " + city + ": "
                            + faculty.countStudentsFromCity(city));

                    break;
                }

                case "CHECK_DATES": {

                    rvalue++;

                    System.out.print("Latest contact: ");
                    Contact latestContact = faculty.getStudent(rindex)
                            .getLatestContact();
                    if (latestContact.getType().equals("Email"))
                        System.out.println(((EmailContact) latestContact)
                                .getEmail());
                    if (latestContact.getType().equals("Phone"))
                        System.out.println(((PhoneContact) latestContact)
                                .getPhone()
                                + " ("
                                + ((PhoneContact) latestContact).getOperator()
                                .toString() + ")");

                    if (faculty.getStudent(rindex).getEmailContacts().length > 0
                            && faculty.getStudent(rindex).getPhoneContacts().length > 0) {
                        System.out.print("Number of email and phone contacts: ");
                        System.out
                                .println(faculty.getStudent(rindex)
                                        .getEmailContacts().length
                                        + " "
                                        + faculty.getStudent(rindex)
                                        .getPhoneContacts().length);

                        System.out.print("Comparing dates: ");
                        int posEmail = rvalue
                                % faculty.getStudent(rindex).getEmailContacts().length;
                        int posPhone = rvalue
                                % faculty.getStudent(rindex).getPhoneContacts().length;

                        System.out.println(faculty.getStudent(rindex)
                                .getEmailContacts()[posEmail].isNewerThan(faculty
                                .getStudent(rindex).getPhoneContacts()[posPhone]));
                    }

                    break;
                }

                case "PRINT_FACULTY_METHODS": {
                    System.out.println("Faculty: " + faculty.toString());
                    System.out.println("Student with most contacts: "
                            + faculty.getStudentWithMostContacts().toString());
                    break;
                }

            }

        }

        scanner.close();
    }
}
