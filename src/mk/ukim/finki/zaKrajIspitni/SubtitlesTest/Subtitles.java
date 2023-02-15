package mk.ukim.finki.zaKrajIspitni.SubtitlesTest;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//public class Subtitles {
//    List<Subtitle> subtitleList;
//
//    public Subtitles() {
//        this.subtitleList = new ArrayList<>();
//    }
//
//    public int loadSubtitles(InputStream in) {
//        Scanner scanner = new Scanner(in);
//        int n = 0;
//        String from;
//        String to;
//        StringBuilder text = null;
//        while (scanner.hasNextLine()) {
//            n = Integer.parseInt(scanner.nextLine());
//            String[] line = scanner.nextLine().split(" --> ");
//            from = line[0];
//            to = line[1];
//            text = new StringBuilder(scanner.nextLine());
//            while (scanner.hasNextLine()) {
//                String test = scanner.nextLine();
//                if (test.equals(""))
//                    break;
//                text.append("\n");
//                text.append(test);
//            }
//            subtitleList.add(new Subtitle(n, from, to, text.toString()));
//        }
//        return n;
//    }
//
//    public void print() {
//        subtitleList.forEach(System.out::println);
//    }
//
//    public void shift(int shift) {
//        subtitleList.forEach(i -> i.shift(shift));
//    }
//}
