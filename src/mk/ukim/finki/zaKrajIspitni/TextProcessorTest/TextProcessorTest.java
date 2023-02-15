package mk.ukim.finki.zaKrajIspitni.TextProcessorTest;

import java.io.*;
import java.util.*;

class TextProcessor {
    Map<String, Integer> words;
    Set<String> sentences;

    public TextProcessor() {
        this.words = new TreeMap<>();
        this.sentences = new HashSet<>();
    }

    public void readText(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().replaceAll("\\d", "");
            String[] lineSplit = line.split(" ");
            sentences.add(line);
            for (String s : lineSplit) {
                if (words.containsKey(s.toLowerCase())) {
                    words.put(s.toLowerCase(), words.get(s.toLowerCase()) + 1);
                } else {
                    words.put(s.toLowerCase().replaceAll("\\.", "").replaceAll(",", ""), 1);
                }
            }
        }
    }

    public void printTextsVectors(PrintStream out) {
        StringBuilder sb = new StringBuilder();
        sentences.forEach(sentences -> {
            sb.append("[");
            String[] sentenceSplit = sentences.split(" ");
            for (String a : words.keySet()) {
                int count = 0;
                for (String word : sentenceSplit) {
                    if (a.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                sb.append(count).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
            sb.append("]\n");
        });
        System.out.println(sb);
    }

    public void printCorpus(PrintStream out, int i, boolean ascending) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        words.keySet().stream().sorted(ascending ? Comparator.reverseOrder() : Comparator.naturalOrder()).limit(i).forEach(key -> {
            try {
                writer.write(String.format("%s : %d\n", key.toLowerCase(), words.get(key)));
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void mostSimilarTexts(PrintStream out) throws IOException {
        String s1Final = "";
        String s2Final = "";
        float countSameWords = 0;
        float max = 0;
        for (String s1 : sentences) {
            s1.replaceAll("\\.", "").replaceAll(",", "");
            String[] firsLineSplit = s1.split(" ");
            for (String s2 : sentences) {
                s2.replaceAll("\\.", "").replaceAll(",", "");
                String[] secondLineSPlit = s2.split(" ");
                if (!s1.equals(s2)) {
                    for (String s : firsLineSplit) {
                        for (String value : secondLineSPlit) {
                            if (s.equalsIgnoreCase(value))
                                countSameWords++;
                        }
                    }
                }
                countSameWords = countSameWords * 2 / (secondLineSPlit.length + firsLineSplit.length);
//                max = max * 2 / (secondLineSPlit.length + firsLineSplit.length);
                if (max < countSameWords) {
                    s1Final = s1;
                    s2Final = s2;
                    max = countSameWords;
                }
                countSameWords = 0;
            }
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write(s1Final + "\n");
        writer.write(s2Final + "\n");
        writer.write(String.format("%.10f", max));
        writer.flush();
    }
}

class CosineSimilarityCalculator {
    public static double cosineSimilarity(Collection<Integer> c1, Collection<Integer> c2) {
        int[] array1;
        int[] array2;
        array1 = c1.stream().mapToInt(i -> i).toArray();
        array2 = c2.stream().mapToInt(i -> i).toArray();
        double up = 0.0;
        double down1 = 0, down2 = 0;

        for (int i = 0; i < c1.size(); i++) {
            up += (array1[i] * array2[i]);
        }

        for (int i = 0; i < c1.size(); i++) {
            down1 += (array1[i] * array1[i]);
        }

        for (int i = 0; i < c1.size(); i++) {
            down2 += (array2[i] * array2[i]);
        }

        return up / (Math.sqrt(down1) * Math.sqrt(down2));
    }
}

public class TextProcessorTest {

    public static void main(String[] args) throws IOException {
        TextProcessor textProcessor = new TextProcessor();

        textProcessor.readText(System.in);

        System.out.println("===PRINT VECTORS===");
        textProcessor.printTextsVectors(System.out);

        System.out.println("PRINT FIRST 20 WORDS SORTED ASCENDING BY FREQUENCY ");
        textProcessor.printCorpus(System.out, 20, true);

        System.out.println("PRINT FIRST 20 WORDS SORTED DESCENDING BY FREQUENCY");
        textProcessor.printCorpus(System.out, 20, false);

        System.out.println("===MOST SIMILAR TEXTS===");
        textProcessor.mostSimilarTexts(System.out);
    }
}