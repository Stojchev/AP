package mk.ukim.finki.zaKrajIspitni.SubtitlesTest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubtitlesTest {
    public static void main(String[] args) {
        Subtitles subtitles = new Subtitles();
        int n = subtitles.loadSubtitles(System.in);
        System.out.println("+++++ ORIGINIAL SUBTITLES +++++");
        subtitles.print();
        int shift = n * 37;
        shift = (shift % 2 == 1) ? -shift : shift;
        System.out.println(String.format("SHIFT FOR %d ms", shift));
        subtitles.shift(shift);
        System.out.println("+++++ SHIFTED SUBTITLES +++++");
        subtitles.print();
    }
}

class Subtitles {
    List<Subtitle> subtitleList;

    public Subtitles() {
        this.subtitleList = new ArrayList<>();
    }

    public int loadSubtitles(InputStream in) {
        Scanner scanner = new Scanner(in);
        int n = 0;
        String from;
        String to;
        StringBuilder text = null;
        while (scanner.hasNextLine()) {
            n = Integer.parseInt(scanner.nextLine());
            String[] line = scanner.nextLine().split(" --> ");
            from = line[0];
            to = line[1];
            text = new StringBuilder(scanner.nextLine());
            while (scanner.hasNextLine()) {
                String test = scanner.nextLine();
                if (test.equals(""))
                    break;
                text.append("\n");
                text.append(test);
            }
            subtitleList.add(new Subtitle(n, from, to, text.toString()));
        }
        return n;
    }

    public void print() {
        subtitleList.forEach(System.out::println);
    }

    public void shift(int shift) {
        subtitleList.forEach(i -> i.shift(shift));
    }
}

class Subtitle {
    int id;
    String from;
    String to;
    String text;

    public Subtitle(int id, String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.id = id;
    }

    public void shift(int ms) {
        shiftForOne(ms, from, 1);
        shiftForOne(ms, to, 2);
    }

    public void shiftForOne(int ms, String where, int n) {
        String[] splitFrom = where.split(":");
        String[] splitFromLast = splitFrom[splitFrom.length - 1].split(",");
        splitFromLast[1] = String.valueOf(Integer.parseInt(splitFromLast[1]) + ms);
        if (splitFromLast[1].compareTo("999") > 0) {
            splitFromLast[1] = String.valueOf(Integer.parseInt(splitFromLast[1]) - 999);
            splitFromLast[0] = String.valueOf(Integer.parseInt(splitFromLast[0]) + 1);
        }
        if (n == 1) {
            from = String.format("%s:%s:%s,%s", splitFrom[0], splitFrom[1], splitFromLast[0], splitFromLast[1]);
        } else to = String.format("%s:%s:%s,%s", splitFrom[0], splitFrom[1], splitFromLast[0], splitFromLast[1]);
    }


    @Override
    public String toString() {
        return String.format("%d\n%s --> %s\n%s\n", id, from, to, text);
    }
}

// Вашиот код овде
