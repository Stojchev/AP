package mk.ukim.finki.vtorKolokviumIspitni.AirportsTest;

import java.util.*;
import java.util.stream.Collectors;

class Airport {
    public String name;
    public String country;
    public String code;
    public int passengers;

    public Airport() {
    }

    public Airport(String name, String country, String code, int passengers) {
        this.name = name;
        this.country = country;
        this.code = code;
        this.passengers = passengers;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPassengers() {
        return passengers;
    }
}


class Airports {
    List<Airport> airportList;
    Set<Flight> flightsList;

    public Airports() {
        this.airportList = new ArrayList<>();
        this.flightsList = new HashSet<>();
    }

    public void addAirport(String part, String part1, String part2, int parseInt) {
        airportList.add(new Airport(part, part1, part2, parseInt));
    }

    public void addFlights(String from, String to, int time, int duration) {
        flightsList.add(new Flight(from, to, time, duration));
    }

    public void showFlightsFromAirport(String code) {
        Airport airportTmp=new Airport();
        for(Airport airport:airportList){
            if(airport.getCode().equals(code))
                airportTmp=airport;
        }
        System.out.printf("%s (%s)\n%s\n%d%n",airportTmp.getName(),airportTmp.getCode(),airportTmp.getCountry(),airportTmp.getPassengers());
        int count = 1;
        for (Flight fl : flightsList.stream().sorted(Comparator.comparing(Flight::getTo).thenComparing(Flight::getTimeTakeOff)).filter(i -> i.getFrom().equals(code)).collect(Collectors.toList())) {
            System.out.printf("%d. %s%n", count++, fl.toString());
        }
    }

    public void showDirectFlightsFromTo(String from, String to) {
        long size=flightsList.stream().filter(i -> i.getFrom().equals(from) && i.getTo().equals(to)).count();
        if(size==0)
            System.out.println(String.format("No flights from %s to %s",from,to));
        else flightsList.stream().filter(i -> i.getFrom().equals(from) && i.getTo().equals(to)).forEach(i -> System.out.println(i.toString()));
    }

    public void showDirectFlightsTo(String to) {
        flightsList.stream().filter(i -> i.getTo().equals(to)).sorted(Comparator.comparing(Flight::getTimeTakeOff)).forEach(i -> System.out.println(i.toString()));
    }
}

class Flight {
    String from;
    String to;
    String timeTakeOff;
    String timeLand;
    String duration;

    public Flight(String from, String to, int time, int duration) {
        this.from = from;
        this.to = to;
        this.timeTakeOff = String.format("%02d:%02d", time / 60, time % 60);
        if (time + duration <= 1440) {
            if (time % 60 + duration % 60 < 60)
                this.timeLand = String.format("%02d:%02d", (time / 60 + duration / 60), time % 60 + duration % 60);
            else
                this.timeLand = String.format("%02d:%02d", (time / 60 + duration / 60 + 1), (time % 60 + duration % 60 - 60));
            this.duration = String.format("%dh%02dm", duration / 60, duration % 60);
        } else {
            if (time % 60 + duration % 60 < 60)
                this.timeLand = String.format("%02d:%02d", (time / 60 + duration / 60 - 24), time % 60 + duration % 60);
            else
                this.timeLand = String.format("%02d:%02d", (time / 60 + duration / 60 + 1 - 24), (time % 60 + duration % 60 - 60));
            this.duration = String.format("+%dd %dh%02dm", (duration + time) / 1440, duration / 60, duration % 60);
        }
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTimeTakeOff() {
        return timeTakeOff;
    }

    @Override
    public String toString() {
        return String.format("%s-%s %s-%s %s", from, to, timeTakeOff, timeLand, duration);
    }
}

public class AirportsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airports airports = new Airports();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] codes = new String[n];
        for (int i = 0; i < n; ++i) {
            String al = scanner.nextLine();
            String[] parts = al.split(";");
            airports.addAirport(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
            codes[i] = parts[2];
        }
        int nn = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < nn; ++i) {
            String fl = scanner.nextLine();
            String[] parts = fl.split(";");
            airports.addFlights(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
        }
        int f = scanner.nextInt();
        int t = scanner.nextInt();
        String from = codes[f];
        String to = codes[t];
        System.out.printf("===== FLIGHTS FROM %S =====\n", from);
        airports.showFlightsFromAirport(from);
        System.out.printf("===== DIRECT FLIGHTS FROM %S TO %S =====\n", from, to);
        airports.showDirectFlightsFromTo(from, to);
        t += 5;
        t = t % n;
        to = codes[t];
        System.out.printf("===== DIRECT FLIGHTS TO %S =====\n", to);
        airports.showDirectFlightsTo(to);
    }
}

// vashiot kod ovde

