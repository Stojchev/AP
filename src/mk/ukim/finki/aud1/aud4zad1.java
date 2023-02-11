package mk.ukim.finki.aud1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class aud4zad1 {
    static int SIZE = 1000000;
    static int SEARCHER = 1000;
    static Random RANDOM = new Random();
    static int ARRAY[] = new int[SIZE];
    public static void main(String[] args) throws ParseException {
//        // samo zameni gi vrednostite za xi
//        float[] list ={(float) 21.96,
//                (float) 22.13, (float) 22.38,
//                (float) 22.49, (float) 22.69,
//                (float) 22.83, (float) 22.90,
//                (float) 23.45};
//        int n= list.length;
//        float xprim= 0;
//        for (float v : list) {
//            xprim += v;
//        }
//        xprim=xprim/n;
//        System.out.println("xprim="+xprim);
//        float sum=0;
//        for (float v : list) {
//            sum += v * v;
//        }
//        //Ako sa dadani vrednostite sum,n,xprim samo sa zamenavat tuka!!!
//        //sum=39891;
//        //n=12;
//        //xprim= (float) 34.1;
//        System.out.println("Sx="+(sum-(n*xprim*xprim))/(n-1));
//        Random random=new Random();
//        List<Integer> elements=new ArrayList<>();
//        IntStream.range(0,100).forEach(i->elements.add(random.nextInt(100)));
//        System.out.println(elements);
        //IntStream.range(0,100).forEach(elements::add);
//        System.out.println(lowerThen(12));
//        System.out.println(Between(12,40));
//        System.out.println(getSum());
//        LinkedList<String> list= new LinkedList<>();
//        list.add("tar");
//        list.add("123");
//        list.add("323");
//        Collections.reverse(list);
//        StringBuilder builder=new StringBuilder();
//        System.out.println(list.size());
//        System.out.println(list.size());
//        builder= new StringBuilder(list.get(0));
//        for(int i=0;i<list.size();i++){
//            builder= new StringBuilder(list.get(i));
//            list.remove(i);
//            list.add(i, String.valueOf(builder.reverse()));
//        }
//        System.out.println(list);
//        int time=764;
//        String t=String.valueOf(time/60+":"+time%60);
//        System.out.println(t);
        for (int i = 0; i < SIZE; i++) {
            ARRAY[i] = RANDOM.nextInt(1000000);
        }

        LocalDateTime startTime = LocalDateTime.now();
        int max = Arrays.stream(ARRAY).max().getAsInt();
        LocalDateTime endTime = LocalDateTime.now();
        System.out.printf("Finding maximum with linear search: %d\n", Duration.between(startTime,endTime).toMillis());

        startTime = LocalDateTime.now();
        List<Searcher> searchers = new ArrayList<>();
        int step = SIZE / SEARCHER;
        for (int start = 0; start < SIZE; start += step) {
            int end = start+step;
            searchers.add(new Searcher(start, end));
        }

        searchers.forEach(Searcher::start);
        for (Searcher searcher : searchers) {
            try {
                searcher.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(searchers.stream()
                .mapToInt(Searcher::getMax)
                .max()
                .getAsInt()
        );
        endTime = LocalDateTime.now();

        System.out.printf("Finding max with threads took %d", Duration.between(startTime, endTime).toMillis());

    }

    public static List<Integer> lowerThen(Integer element) {
        Random random = new Random();
        List<Integer> elements = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> elements.add(random.nextInt(100)));
        System.out.println(elements);
        return elements.stream().filter(integer -> integer < element).collect(Collectors.toList());
    }

    public static List<Integer> Between(Integer a, Integer b) {
        Random random = new Random();
        List<Integer> elements = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> elements.add(random.nextInt(100)));
        System.out.println(elements);
        return elements.stream().filter(integer -> integer > a && integer < b).collect(Collectors.toList());
    }

    public static double getSum() {
        Random random = new Random();
        List<Integer> elements = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> elements.add(random.nextInt(5)));
        System.out.println(elements);
        return elements.stream().mapToDouble(i -> i).sum();
    }

    public static double getAverage() {
        Random random = new Random();
        List<Integer> elements = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> elements.add(random.nextInt(5)));
        System.out.println(elements);
        return elements.stream().mapToDouble(i -> i).summaryStatistics().getAverage();
    }
}
class Searcher extends Thread {
    int start;
    int end;
    int max;

    public Searcher(int start, int end) {
        this.start = start;
        this.end = end;
        max = aud4zad1.ARRAY[start];
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        for (int i = start + 1; i < end; i++) {
            if (aud4zad1.ARRAY[i] > max) {
                max = aud4zad1.ARRAY[i];
            }
        }
    }
}