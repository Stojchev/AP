package mk.ukim.finki.vtorKolokviumIspitni.EventCalendarTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

//public class EventCalendar {
//    int year;
//    Set<Event> events;
//
//    public EventCalendar(int year) {
//        this.year = year;
//        this.events = new HashSet<>();
//    }
//
//    public void addEvent(String name, String location, Date date) throws ParseException, WrongDateException {
//        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
//        Date from = format.parse("1.1." + String.valueOf(year) + " 00:00");
//        Date to = format.parse("31.12." + String.valueOf(year) + " 23:59");
//        if (date.after(from) && date.before(to)) {
//            events.add(new Event(name, location, date));
//        } else throw new WrongDateException(date);
//    }
//
//    public void listEvents(Date date) {
//        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//        c1.setTime(date);
//        events.stream().filter(i->{
//            c2.setTime(i.getDate());
//            return c1.get(Calendar.DAY_OF_YEAR)==c2.get(Calendar.DAY_OF_YEAR);
//        }).sorted(Comparator.comparing(Event::getDate).thenComparing(Event::getName)).
//                collect(Collectors.toList())
//                .forEach(i-> System.out.println(
//                        String.format("%d %s, %s %s at %s, %s",c1.get(Calendar.DAY_OF_MONTH),i.getMonth(),i.getYear(),i.getHour(),i.getLocation(),i.getName())));
//    }
//
//    public void listByMonth() {
//        Calendar c = Calendar.getInstance();
//        for(int i=1;i<=12;i++){
//            int finalI = i;
//            System.out.println(i+" : "+ (long) events.stream().filter(j -> {
//                c.setTime(j.getDate());
//                return c.get(Calendar.MONTH) == finalI-1;
//            }).collect(Collectors.toList()).size());
//        }
//    }
//}
