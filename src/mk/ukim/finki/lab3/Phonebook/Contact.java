package mk.ukim.finki.lab3.Phonebook;

import java.util.ArrayList;

//public class Contact {
//    String name;
//    ArrayList<String> numbers = new ArrayList<>();
//
//    public Contact(String name,  String ...number) throws InvalidNameException{
//        if (name.length() > 4 && name.length() <= 10 && name.matches("\\w+"))
//            this.name = name;
//        else throw new InvalidNameException();
//        for (String s : number) {
//            try {
//                addNumber(s);
//            } catch (MaximumSizeExceddedException | InvalidNumberException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//
//    public Contact(String name) {
//        this.name=name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String[] getNumbers() {
//        return numbers.stream().sorted().toArray(String[]::new);
//    }
//    public void addNumber(String number) throws MaximumSizeExceddedException, InvalidNumberException {
//        if (number.length() == 9 && (number.substring(0, 3).equals("070") || number.substring(0, 3).equals("071") ||
//                number.substring(0, 3).equals("072") || number.substring(0, 3).equals("075") ||
//                number.substring(0, 3).equals("076") || number.substring(0, 3).equals("077") ||
//                number.substring(0, 3).equals("078"))) {
//            if(numbers.size()<5)
//                numbers.add(number);
//            else throw new MaximumSizeExceddedException();
//        } else throw new InvalidNumberException();
//    }
//
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(this.name);sb.append("\n");
//        sb.append(this.numbers.size());sb.append("\n");
//        for (String i : getNumbers()){sb.append(i);sb.append("\n");}
//        return sb.toString();
//    }
//}
