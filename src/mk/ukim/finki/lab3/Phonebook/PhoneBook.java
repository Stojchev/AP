package mk.ukim.finki.lab3.Phonebook;

import java.util.Arrays;
import java.util.Comparator;

//public class PhoneBook {
//
//    Contact[] contacts;
//
//    PhoneBook() {
//        this.contacts=new Contact[0];
//    }
//
//    void addContact(Contact contact) throws Exception {
//        if (contacts.length == 250) throw new MaximumSizeExceddedException();
//        if(contactExists(contact.name)) throw new InvalidNameException();
//        Contact[] temp = Arrays.copyOf(contacts, contacts.length+1);
//        temp[temp.length-1]=contact;
//        contacts=temp;
//    }
//    boolean contactExists(String contact){
//        return Arrays.stream(contacts).anyMatch(a-> a.name.equals(contact));
//    }
//    Contact getContactForName(String name) throws Exception{
//        for (Contact contact1 : contacts)
//            if (contact1.getName().equals(name))
//                return contact1;
//        return null;
//    }
//
//    int numberOfContacts() {
//        return contacts.length;
//    }
//
//    Contact[] getContacts() {
//        return Arrays.stream(contacts).sorted(Comparator.comparing(Contact::getName)).toArray(Contact[]::new);
//    }
//
//    void removeContact(String name) {
//        if(contactExists(name)) {
//            contacts = Arrays.stream(contacts).filter(a-> !a.getName().equals(name)).toArray(Contact[]::new);
//        }
//    }
//
//    static void saveAsTextFile(PhoneBook phonebook, String path){
//    }
//    static PhoneBook loadFromTextFile(String path){
//        return new PhoneBook();
//    }
//
//    Contact[] getContactsForNumber(String number_prefix) {
//        return Arrays.stream(contacts)
//                .filter(a-> Arrays.stream(a.getNumbers()).anyMatch(b->b.startsWith(number_prefix))).toArray(Contact[]::new);
//    }
//
//    public String toString() {
//        return Arrays.toString(contacts);
//    }
//}
