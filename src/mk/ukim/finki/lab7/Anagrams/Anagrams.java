package mk.ukim.finki.lab7.Anagrams;

import java.io.InputStream;
import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        findAll(System.in);
    }

    public static void findAll(InputStream inputStream) {
        Set<String> listOfWords = new TreeSet<>();
        Scanner scanner = new Scanner(inputStream);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            listOfWords.add(line);
        }
        printAllAnagramsFromString(listOfWords);
    }

    public static boolean checkForSameCharacters(String s1, String s2) {
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public static void printAllAnagramsFromString(Set<String> listOfWords) {
        Map<String, Set<String>> anagram = new TreeMap<>();
        Set<String> tmp = new TreeSet<>(listOfWords);
        for (String s1 : listOfWords) {
            Set<String> anagrams = new TreeSet<>();
            for (String s2 : listOfWords) {
                if (checkForSameCharacters(s1, s2) && tmp.contains(s2)) {
                    anagrams.add(s2);
                    tmp.remove(s2);
                }
            }
            if (anagrams.size() >= 5) {
                anagram.putIfAbsent(s1, new TreeSet<>());
                anagram.get(s1).add(anagrams.toString());
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String key : anagram.keySet()){
                sb.append(String.join(" ", anagram.get(key)));
                sb.append("\n");
        }
        System.out.println(sb.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",",""));
    }
}
