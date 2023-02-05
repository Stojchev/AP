//package mk.ukim.finki.lab2.ContactsTester;
//
//abstract class Contact {
//
//    protected int day;
//    protected int month;
//    protected int year;
//
//    Contact(String date) {
//        String[] dateSplit = date.split("-");
//        year = Integer.parseInt(dateSplit[0]);
//        month = Integer.parseInt(dateSplit[1]);
//        day = Integer.parseInt(dateSplit[2]);
//    }
//
//    boolean isNewerThan(Contact c) {
//        if (year > c.getYear())
//            return true;
//        if (year == c.getYear() && month > c.getMonth())
//            return true;
//        return year == c.getYear() && month == c.getMonth() && day > c.getDay();
//    }
//
//    public abstract String getType();
//
//    public int getDay() {
//        return day;
//    }
//
//    public int getMonth() {
//        return month;
//    }
//
//    public int getYear() {
//        return year;
//    }
//}
