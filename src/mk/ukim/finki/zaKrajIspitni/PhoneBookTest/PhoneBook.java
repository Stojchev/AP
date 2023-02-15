package mk.ukim.finki.zaKrajIspitni.PhoneBookTest;

import java.util.*;

//public class PhoneBook {
//    Map<String, String> phoneBookMap;
//    List<String> setForNumbers;
//
//    public PhoneBook() {
//        this.phoneBookMap = new HashMap<>();
//        this.setForNumbers = new ArrayList<>();
//    }
//
//    public void addContact(String name, String number) throws DuplicateNumberException {
//        if (setForNumbers.contains(number))
//            throw new DuplicateNumberException(number);
//        setForNumbers.add(number);
//        phoneBookMap.put(name, number);
//    }
//
//    public void contactsByNumber(String part) {
//        long count = 0;
//        for (Map.Entry<String, String> entry : phoneBookMap.entrySet()) {
//            if (entry.getValue().contains(part)) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//                count++;
//            }
//        }
//        if (count == 0) System.out.println("NOT FOUND");
//    }
//
//    public void contactsByName(String name) {
//        long count = 0;
//        phoneBookMap.entrySet().stream().filter(i -> i.getKey().equals(name)).forEach(i -> System.out.println(i.getKey() + " " + i.getValue()));
//        //if (count == 0) System.out.println("NOT FOUND");
//    }
//}
