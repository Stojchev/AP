package mk.ukim.finki.vtorKolokviumIspitni.EventCalendarTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
class Event {
    String name;
    String location;
    Date date;

    public Event(String name, String location, Date date) {
        this.name = name;
        this.location = location;
        this.date = date;

    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getMonth() {
        String dateToString = date.toString();
        return dateToString.split(" ")[1];
    }

    public String getYear() {
        String dateToString = date.toString();
        return dateToString.split(" ")[5];
    }

    public String getHour() {
        String dateToString = date.toString();
        return dateToString.split(" ")[3].split(":")[0]+":"+dateToString.split(" ")[3].split(":")[1];
    }

    public String getLocation() {
        return location;
    }

}
class WrongDateException extends Exception {
    public WrongDateException(Date date) {
        super("Wrong date: " + date);
    }
}


class EventCalendar {
    int year;
    Set<Event> events;

    public EventCalendar(int year) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        this.year = year;
        this.events = new HashSet<>();
    }

    public void addEvent(String name, String location, Date date) throws ParseException, WrongDateException {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date from = format.parse("1.1." + String.valueOf(year) + " 00:00");
        Date to = format.parse("31.12." + String.valueOf(year) + " 23:59");
        if (date.after(from) && date.before(to)) {
            events.add(new Event(name, location, date));
        } else throw new WrongDateException(date);
    }

    public void listEvents(Date date) {
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        c1.setTime(date);
        AtomicInteger count= new AtomicInteger(0);
        events.stream().filter(i -> {
                    c2.setTime(i.getDate());
                    return c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
                }).sorted(Comparator.comparing(Event::getDate).thenComparing(Event::getName)).
                collect(Collectors.toList())
                .forEach(i -> {
                    count.getAndIncrement();
                    System.out.println(String.format("%d %s, %s %s at %s, %s", c1.get(Calendar.DAY_OF_MONTH), i.getMonth(), i.getYear(), i.getHour(), i.getLocation(), i.getName()));
                });
        if(count.get()==0)
            System.out.println("No events on this day!");
    }

    public void listByMonth() {
        Calendar c = Calendar.getInstance();
        for (int i = 1; i <= 12; i++) {
            int finalI = i;
            System.out.println(i + " : " + (long) events.stream().filter(j -> {
                c.setTime(j.getDate());
                return c.get(Calendar.MONTH) == finalI - 1;
            }).collect(Collectors.toList()).size());
        }
    }
}

public class EventCalendarTest {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int year = scanner.nextInt();
        scanner.nextLine();
        EventCalendar eventCalendar = new EventCalendar(year);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        for (int i = 0; i < n; ++i) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            String name = parts[0];
            String location = parts[1];
            Date date = df.parse(parts[2]);
            try {
                eventCalendar.addEvent(name, location, date);
            } catch (WrongDateException e) {
                System.out.println(e.getMessage());
            }
        }
        Date date = df.parse(scanner.nextLine());
        eventCalendar.listEvents(date);
        eventCalendar.listByMonth();
    }
}

// vashiot kod ovde