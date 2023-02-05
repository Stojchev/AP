package mk.ukim.finki.vtorKolokviumIspitni.WeatherStationTest;

import java.util.Comparator;
import java.util.Date;

//public class Weather implements Comparator {
//    float temperature;
//    float wind;
//    float humidity;
//    float visibility;
//    Date date;
//
//    public Weather(float temperature, float wind, float humidity, float visibility, Date date) {
//        this.temperature = temperature;
//        this.wind = wind;
//        this.humidity = humidity;
//        this.visibility = visibility;
//        this.date = date;
//    }
//
//    public boolean compareDateByDays(Weather w2, int n) {
//        return Math.abs(date.getTime() - w2.getDate().getTime()) >= n * 86400000L;
//    }
//
//    public boolean compareDateByMinutes(Weather w2) {
//        return Math.abs(date.getTime() - w2.getDate().getTime()) <= 150000L;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        return 0;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%.1f %.1f km/h %.1f%% %.1f km %s",temperature , wind, humidity, visibility, date);
//    }
//
//    public float getTemperature() {
//        return temperature;
//    }
//}
