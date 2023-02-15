package mk.ukim.finki.zaKrajIspitni.TextProcessorTest;

import java.io.*;
import java.util.*;

//public class TextProcessor {
//    Map<String, Integer> words;
//    List<String> sentences;
//
//    public TextProcessor() {
//        this.words = new TreeMap<>();
//        this.sentences = new ArrayList<>();
//    }
//
//    public void readText(InputStream in) {
//        Scanner scanner = new Scanner(in);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine().replaceAll("\\d", "").toLowerCase();
//            String[] lineSplit = line.split(" ");
//            sentences.add(line);
//            for (String s : lineSplit) {
//                if (words.containsKey(s)) {
//                    words.put(s, words.get(s) + 1);
//                } else {
//                    words.put(s, 1);
//                }
//            }
//        }
//    }
//
//    public void printTextsVectors(PrintStream out) {
//        StringBuilder sb = new StringBuilder();
//        sentences.forEach(sentences -> {
//            sb.append("[");
//            String[] sentenceSplit = sentences.split(" ");
//            for (String a : words.keySet()) {
//                int count = 0;
//                for (String word : sentenceSplit) {
//                    if (a.equals(word)) {
//                        count++;
//                    }
//                }
//                sb.append(count).append(", ");
//            }
//            sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
//            sb.append("]\n");
//        });
//        System.out.println(sb);
//    }
//
//    public void printCorpus(PrintStream out, int i, boolean ascending) {
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
//        if (ascending) {
//            words.keySet().stream().limit(i).forEach((key) ->
//            {
//                try {
//                    writer.write(String.format("%s : %d\n", key, words.get(key)));
//                    writer.flush();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        } else {
//            words.keySet().stream().sorted(Comparator.reverseOrder()).limit(i).forEach(key -> {
//                try {
//                    writer.write(String.format("%s : %d\n", key, words.get(key)));
//                    writer.flush();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//    }
//}
