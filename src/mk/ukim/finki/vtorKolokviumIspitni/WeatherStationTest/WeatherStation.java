//package mk.ukim.finki.vtorKolokviumIspitni.WeatherStationTest;
//
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class WeatherStation {
//    Set<Weather> dailyWeather;
//    int days;
//
//    public WeatherStation(int days) {
//        this.days = days;
//        this.dailyWeather = new HashSet<>();
//    }
//
//    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date) {
//        Weather weather = new Weather(temperature, wind, humidity, visibility, date);
//        if (dailyWeather.size() == 0) {
//            dailyWeather.add(weather);
//            return;
//        }
//        boolean flag = true;
//        for (Weather weather1 : dailyWeather.stream().toList()) {
//            if (weather1.compareDateByMinutes(weather)) {
//                flag = false;
//                break;
//            }
//        }
//        if (flag) dailyWeather.add(weather);
//        for (Weather weather1 : dailyWeather.stream().toList()) {
//            if (weather1.compareDateByDays(weather, days) && weather1 != weather)
//                dailyWeather.remove(weather1);
//        }
//    }
//
//    public int total() {
//        return dailyWeather.size();
//    }
//
//    public void status(Date from, Date to) {
//         dailyWeather.stream().filter(i -> (i.getDate().after(from) && i.getDate().before(to)) ||
//                         i.getDate().compareTo(from)==0 || i.getDate().compareTo(to)==0)
//                 .toList().stream().sorted(Comparator.comparing(Weather::getDate)).toList()
//                 .forEach(i-> System.out.println(i.toString()));
//    }
//    public double average(){
//        double temperature=0.0;
//        for(Weather w1:dailyWeather){
//            temperature+=w1.getTemperature();
//        }
//        return temperature/dailyWeather.size();
//    }
//}
