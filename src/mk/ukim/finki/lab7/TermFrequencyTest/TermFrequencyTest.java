package mk.ukim.finki.lab7.TermFrequencyTest;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TermFrequencyTest {
    public static void main(String[] args) throws FileNotFoundException {
        String[] stop = new String[]{"во", "и", "се", "за", "ќе", "да", "од",
                "ги", "е", "со", "не", "тоа", "кои", "до", "го", "или", "дека",
                "што", "на", "а", "но", "кој", "ја"};
        TermFrequency tf = new TermFrequency(System.in, stop);
        System.out.println(tf.countTotal());
        System.out.println(tf.countDistinct());
        System.out.println(tf.mostOften(10));
    }
}

class TermFrequency {
    private Set<String> ignoringWords;
    private Map<String, Integer> wordsCounter;
    private Set<String> words;
    private int countAllWords;
    private int uniqueWords;

    public TermFrequency(InputStream in, String[] stop) {
        this.ignoringWords = new TreeSet<>();
        this.words = new HashSet<>();
        for (String s1 : stop) {
            String s = toLowerCase(s1);
            ignoringWords.add(s.toLowerCase());
        }
        this.wordsCounter = new TreeMap<>();
        countAllWords = 0;
        readText(in);
    }

    public String toLowerCase(String s1) {
        return s1.toLowerCase().replace(",", "").replaceAll("\\.", "");
    }

    public void readText(InputStream in) {
        Scanner scanner = new Scanner(in);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] lineSplit = line.split(" ");
            for (String s1 : lineSplit) {
                String s = toLowerCase(s1);
                if (!ignoringWords.contains(s)&& !s.equals("")) {
                    countAllWords++;
                    if (!words.contains(s)) {
                        words.add(s);
                        wordsCounter.put(s, 1);
                    }
                    wordsCounter.put(s, wordsCounter.get(s) + 1);
                }
            }
        }
    }

    public int countTotal() {
        return countAllWords;
    }

    int countDistinct() {
        return wordsCounter.size();
    }

    public List<String> mostOften(int i) {
        return wordsCounter.keySet().stream().sorted(Comparator.comparing(key->wordsCounter.get(key)).reversed()).collect(Collectors.toList()).subList(0,i);
    }
}

