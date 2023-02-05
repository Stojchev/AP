package mk.ukim.finki.prvKolokIspitni.Shapes1Test;

import java.util.Date;

public class Weather {
    private float temp;
    private float wind;
    private float hum;
    private float vis;
    private Date date;

    public Weather(float temp, float wind, float hum, float vis, Date date) {
        this.temp = temp;
        this.wind = wind;
        this.hum = hum;
        this.vis = vis;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int compareTo(Weather w) {
        int result = (int) (w.getDate().getTime() - date.getTime());
        if (Math.abs(result) >= 150000)
            return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f km/h %.2f %.2f %s",temp,wind,hum,vis,date);
    }
}
