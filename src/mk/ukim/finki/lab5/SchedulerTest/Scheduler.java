//package mk.ukim.finki.lab5.SchedulerTest;
//
//import java.sql.Time;
//import java.time.LocalDateTime;
//import java.util.*;
//
//public class Scheduler<T> {
//    private TreeSet<Timestamp<T>> timestamps;
//
//    public void add(Timestamp<T> t) {
//        timestamps.add(t);
//    }
//
//    public boolean remove(Timestamp<T> t) {
//        if (timestamps.contains(t)) {
//            timestamps.remove(t);
//            return true;
//        } else return false;
//    }
//
//    public Timestamp<T> next() {
//        return this.timestamps.higher(new Timestamp<>());
//    }
//
//    public Timestamp<T> last() {
//        return this.timestamps.lower(new Timestamp<>());
//    }
//
//    public List<Timestamp<T>> getAll(LocalDateTime begin, LocalDateTime end) {
//        return new ArrayList<>(this.timestamps.subSet(new Timestamp<>(begin), false, new Timestamp<>(end), false));
//    }
//}
