package mk.ukim.finki.aud1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.function.*;

public class zadaca1 {
    public static void main(String[] args) throws ParseException {
//        Random random = new Random();
//        System.out.println(random.nextLong());
//
//        String money1 = "10.0$";
//        String money2 = "10.0$";
//        double n = Double.parseDouble(money1.replace("$", ""));
//        System.out.println(n);
//        String test = "078654984";
//        System.out.println(test.matches("\\w+"));
//        System.out.println(test.length());
//        System.out.println(test.substring(0, 3));
//        ArrayList<String> numbers = new ArrayList<>();
//        numbers.add("123");
//        numbers.add("123");
//        numbers.add("123");
//        numbers.add("123");
//        numbers.add("123");
//        System.out.println(numbers.size());
//        String[] list = numbers.toArray(new String[0]);
//        System.out.println(Arrays.toString(list));
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(1);
//
//        Predicate<Integer> LessThan100 = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer < 100;
//            }
//        };
//
//        Predicate<Integer> lessThan100 = integer -> integer < 100;
//
//        Supplier<Integer> IntegerSuplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return new Random().nextInt(1000);
//            }
//        };
//
//        Supplier<Integer> StringSuplier = () -> new Random().nextInt(1000);
//
//
//        Consumer<String> StringConsumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        Consumer<String> stringConsumer = System.out::println;
//
//        Function<Integer, String> FormatNumberString = new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) {
//                return String.format(String.valueOf(integer));
//            }
//        };
//
//        Function<Integer, String> formatNumber = integer -> String.format(String.valueOf(integer));
//        BiFunction<Integer, Integer, String> sumNumberAndFormat = new BiFunction<Integer, Integer, String>() {
//            @Override
//            public String apply(Integer integer, Integer integer2) {
//                return String.format(String.valueOf(integer + integer));
//            }
//        };
//
//        BiFunction<Integer, Integer, String> SumNumberAndFormat = (i, j) ->
//                String.format(String.valueOf(i + j));

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("FINKI", 1);
        treeMap.put("FinKI", 2);
        treeMap.put("NP", 3);
        treeMap.put("F", 4);
        treeMap.put("I", 5);
        treeMap.put("F", 6);

        //treeMap.values().stream().sorted(Comparator.comparing());
    }

    public static void shiftRight(int idx, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer temp = list.get(idx);
        System.out.println(list.toString());
        System.out.println(temp);
        int len = idx - k;
        if (len < 0)
            len += list.size() + 1;
        list.add(len, temp);
        list.remove(idx);
        System.out.println(len);
        System.out.println(list.toString());
    }
}
