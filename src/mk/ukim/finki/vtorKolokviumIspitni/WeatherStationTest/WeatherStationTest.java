package mk.ukim.finki.vtorKolokviumIspitni.WeatherStationTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

class Weather implements Comparator {
    float temperature;
    float wind;
    float humidity;
    float visibility;
    Date date;

    public Weather(float temperature, float wind, float humidity, float visibility, Date date) {
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.visibility = visibility;
        this.date = date;
    }

    public boolean compareDateByDays(Weather w2, int n) {
        return Math.abs(date.getTime() - w2.getDate().getTime()) >= n * 86400000L;
    }

    public boolean compareDateByMinutes(Weather w2) {
        return Math.abs(date.getTime() - w2.getDate().getTime()) <= 150000L;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%.1f %.1f km/h %.1f%% %.1f km %s",temperature , wind, humidity, visibility, date);
    }

    public float getTemperature() {
        return temperature;
    }
}


class WeatherStation {
    Set<Weather> dailyWeather;
    int days;

    public WeatherStation(int days) {
        this.days = days;
        this.dailyWeather = new HashSet<>();
    }

    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date) {
        Weather weather = new Weather(temperature, wind, humidity, visibility, date);
        if (dailyWeather.size() == 0) {
            dailyWeather.add(weather);
            return;
        }
        boolean flag = true;
        for (Weather weather1 : dailyWeather.stream().collect(Collectors.toList())) {
            if (weather1.compareDateByMinutes(weather)) {
                flag = false;
                break;
            }
        }
        if (flag) dailyWeather.add(weather);
        for (Weather weather1 : dailyWeather.stream().collect(Collectors.toList())) {
            if (weather1.compareDateByDays(weather, days) && weather1 != weather)
                dailyWeather.remove(weather1);
        }
    }

    public int total() {
        return dailyWeather.size();
    }

    public void status(Date from, Date to) {
        dailyWeather.stream().filter(i -> (i.getDate().after(from) && i.getDate().before(to)) ||
                        i.getDate().compareTo(from)==0 || i.getDate().compareTo(to)==0)
                .collect(Collectors.toList()).stream().sorted(Comparator.comparing(Weather::getDate)).collect(Collectors.toList())
                .forEach(i-> System.out.println(i.toString()));
        float average=0.0F;int count=0;
        for(Weather w1:dailyWeather.stream().filter(i -> (i.getDate().after(from) && i.getDate().before(to)) ||
                        i.getDate().compareTo(from)==0 || i.getDate().compareTo(to)==0)
                .collect(Collectors.toList()).stream().sorted(Comparator.comparing(Weather::getDate)).collect(Collectors.toList()))
        {
            average+=w1.getTemperature();
            count++;
        }
        if(average==0)
            throw new RuntimeException();
        System.out.printf("Average temperature: %.2f%n",average/count);
    }
    public float average(){
        float temperature= 0.0F;
        for(Weather w1:dailyWeather){
            temperature+=w1.getTemperature();
        }
        return temperature/dailyWeather.size();
    }
}


public class WeatherStationTest {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        int n = scanner.nextInt();
        scanner.nextLine();
        WeatherStation ws = new WeatherStation(n);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("=====")) {
                break;
            }
            String[] parts = line.split(" ");
            float temp = Float.parseFloat(parts[0]);
            float wind = Float.parseFloat(parts[1]);
            float hum = Float.parseFloat(parts[2]);
            float vis = Float.parseFloat(parts[3]);
            line = scanner.nextLine();
            Date date = df.parse(line);
            ws.addMeasurment(temp, wind, hum, vis, date);
        }
        String line = scanner.nextLine();
        Date from = df.parse(line);
        line = scanner.nextLine();
        Date to = df.parse(line);
        scanner.close();
        System.out.println(ws.total());
        try {
            ws.status(from, to);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}

// vashiot kod ovde