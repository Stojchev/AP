package mk.ukim.finki.vtorKolokviumIspitni.AirportsTest;

import java.util.*;
import java.util.stream.Collectors;

//public class Airports {
//    List<Airport> airportList;
//    Set<Flight> flightsList;
//
//    public Airports() {
//        this.airportList = new ArrayList<>();
//        this.flightsList = new HashSet<>();
//    }
//
//    public void addAirport(String part, String part1, String part2, int parseInt) {
//        airportList.add(new Airport(part, part1, part2, parseInt));
//    }
//
//    public void addFlights(String from, String to, int time, int duration) {
//        flightsList.add(new Flight(from, to, time, duration));
//    }
//
//    public void showFlightsFromAirport(String code) {
////        Airport airportTmp=new Airport();
////        for(Airport airport:airportList){
////            if(airport.getCode().equals(code))
////                airportTmp=airport;
////        }
//        int count=1;
//        for (Flight fl : flightsList.stream().sorted(Comparator.comparing(Flight::getTo).thenComparing(Flight::getTimeTakeOff)).filter(i -> i.getFrom().equals(code)).collect(Collectors.toList())) {
//            System.out.printf("%d. %s%n",count++,fl.toString());
//        }
//    }
//
//    public void showDirectFlightsFromTo(String from, String to) {
//        flightsList.stream().filter(i->i.getFrom().equals(from)&&i.getTo().equals(to)).forEach(i-> System.out.println(i.toString()));
//    }
//
//    public void showDirectFlightsTo(String to) {
//        flightsList.stream().filter(i->i.getTo().equals(to)).forEach(i-> System.out.println(i.toString()));
//
//    }
//}
