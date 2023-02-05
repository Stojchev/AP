package mk.ukim.finki.prvKolokIspitni.WeatherStation;

import mk.ukim.finki.prvKolokIspitni.Shapes1Test.Weather;

import java.util.ArrayList;
import java.util.Date;

public class WeatherStation {
    ArrayList<Weather> list;
    int days;

    public WeatherStation(int n) {
        this.list = new ArrayList<>();
        this.days = n;
    }

    public WeatherStation() {
        this.list = new ArrayList<>();
        this.days = 0;
    }

    public void addMeasurment(float temp, float wind, float hum, float vis, Date date) {
        Weather weather = new Weather(temp, wind, hum, vis, date);
        if (checkValidation(weather))
            list.add(weather);
    }

    public boolean checkValidation(Weather weather) {
        for (Weather value : list)
            if (value.compareTo(weather) == 1)
                return false;
        return true;
    }

    public double total() {
        System.out.println(list.size());
        return 120;
    }

    public void status(Date from, Date to) {
        boolean flag=false;
        for (Weather weather : list) {
            if (from.before(weather.getDate()) && to.after(weather.getDate()))
                System.out.println(weather.toString());
        }

    }
}
