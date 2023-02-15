package mk.ukim.finki.zaKrajIspitni.SubtitlesTest;

import java.awt.*;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//public class Subtitle {
//    int id;
//    String from;
//    String to;
//    String text;
//
//    public Subtitle(int id, String from, String to, String text) {
//        this.from = from;
//        this.to = to;
//        this.text = text;
//        this.id = id;
//    }
//
//    public void shift(int ms) {
//        String[] splitFrom = from.split(":");
//        String[] splitFromLast = splitFrom[splitFrom.length - 1].split(",");
//        splitFromLast[1] = String.valueOf(Integer.parseInt(splitFromLast[1]) + ms);
//        if (splitFromLast[1].compareTo("999") > 0) {
//            splitFromLast[1] = String.valueOf(999 - Integer.parseInt(splitFromLast[1]));
//            splitFromLast[0] = String.valueOf(Integer.parseInt(splitFromLast[0]) + 1);
//        }
//        from = String.format("%s:%s:%s,%s", splitFrom[0], splitFrom[1], splitFromLast[0], splitFromLast[1]);
//        splitFrom = to.split(":");
//        splitFromLast = splitFrom[splitFrom.length - 1].split(",");
//        splitFromLast[1] = String.valueOf(Integer.parseInt(splitFromLast[1]) + ms);
//        if (splitFromLast[1].compareTo("999") > 0) {
//            splitFromLast[1] = String.valueOf(999 - Integer.parseInt(splitFromLast[1]));
//            splitFromLast[0] = String.valueOf(Integer.parseInt(splitFromLast[0]) + 1);
//        }
//        to = String.format("%s:%s:%s,%s", splitFrom[0], splitFrom[1], splitFromLast[0], splitFromLast[1]);
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%d\n%s --> %s\n%s\n", id, from, to, text);
//    }
//}
