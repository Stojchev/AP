package mk.ukim.finki.lab7.SchedulerTest;
//
//import java.time.Instant;
//import java.util.*;
//
//public class Scheduler<T> {
//    TreeMap<Date, T> treeMap;
//
//    public Scheduler() {
//        this.treeMap = new TreeMap<>();
//    }
//
//    public void add(Date date, T next) {
//        treeMap.put(date, next);
//    }
//
//    public boolean remove(Date d) {
//        return treeMap.remove(d) != null;
//    }
//
//    public T next() {
//        return treeMap.ceilingEntry(Date.from(Instant.now())).getValue();
//    }
//
//    public T last() {
//        return treeMap.floorEntry(Date.from(Instant.now())).getValue();
//    }
//
//
//    public T getFirst() {
//        return treeMap.firstEntry().getValue();
//    }
//
//    public T getLast() {
//        return treeMap.lastEntry().getValue();
//    }
//
//    public ArrayList<T> getAll(Date date, Date date1) {
//        ArrayList<T> result = new ArrayList<>();
//        treeMap.entrySet().forEach(entry -> {
//            if (entry.getKey().after(date) && entry.getKey().before(date1))
//                result.add(entry.getValue());
//        });
//        return result;
//    }
//}
