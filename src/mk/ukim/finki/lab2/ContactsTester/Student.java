//package mk.ukim.finki.lab2.ContactsTester;
//
//import java.util.Arrays;
//
//public class Student {
//    String FirstName;
//    String LastName;
//    String city;
//    int age;
//    long index;
//    Contact[] contacts;
//    static int countContacts = 0;
//
//    public Student(String firstName, String lastName, String city, int age, long index) {
//        FirstName = firstName;
//        LastName = lastName;
//        this.city = city;
//        this.age = age;
//        this.index = index;
//    }
//
//    void addEmailContact(String date, String email) {
//        contacts[countContacts++] = new EmailContact(date, email);
//    }
//
//    void addPhoneContact(String date, String phone) {
//        contacts[countContacts++] = new PhoneContact(date, phone);
//    }
//
//    Contact[] getEmailContacts() {
//        int count = getEmailContactNumber();
//        Contact[] contactEmail = new Contact[count];
//        count = 0;
//        for (Contact contact : contacts) {
//            if (contact.getType().equals("Email"))
//                contactEmail[count++] = contact;
//        }
//        return contactEmail;
//    }
//    int getEmailContactNumber(){
//        int count = 0;
//        for (Contact contact : contacts) {
//            if (contact.getType().equals("Email"))
//                count++;
//        }
//        return count;
//    }
//    int getPhoneContactNumber(){
//        int count = 0;
//        for (Contact contact : contacts) {
//            if (contact.getType().equals("Phone"))
//                count++;
//        }
//        return count;
//    }
//    Contact[] getPhoneContacts() {
//        int count = getPhoneContactNumber();
//        Contact[] contactPhone = new Contact[count];
//        count = 0;
//        for (Contact contact : contacts) {
//            if (contact.getType().equals("Phone"))
//                contactPhone[count++] = contact;
//        }
//        return contactPhone;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getFullName() {
//        return FirstName + " " + LastName;
//    }
//
//    Contact getLatestContact() {
//        Contact contact= contacts[0];
//        for(Contact contact1 : contacts){
//            if(contact.isNewerThan(contact1))
//                contact=contact1;
//        }
//        return contact;
//    }
//
//    public long getIndex() {
//        return index;
//    }
//
//    @Override
//    public String toString() {
//        Contact[] pc=getPhoneContacts();
//        Contact[] ec=getEmailContacts();
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append("{\"ime\":");
//        stringBuilder.append(FirstName);
//        stringBuilder.append("', 'prezime:");
//        stringBuilder.append(LastName);
//        stringBuilder.append("', vozrast':");
//        stringBuilder.append(age);
//        stringBuilder.append(", 'grad':");
//        stringBuilder.append(city);
//        stringBuilder.append("', 'indeks':");
//        stringBuilder.append(index);
//        stringBuilder.append("\n'telefonskiKontakti':[");
//        for(Contact contact:pc){
//            stringBuilder.append(contact.toString());
//        }
//        stringBuilder.append("emailKontakti");
//        for(Contact contact:ec){
//            stringBuilder.append(contact.toString());
//        }
//
//        return stringBuilder.toString();
//    }
//}
