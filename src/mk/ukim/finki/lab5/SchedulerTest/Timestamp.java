//package mk.ukim.finki.lab5.SchedulerTest;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//public class Timestamp<T> implements Comparable<Timestamp<T>> {
//    private final LocalDateTime time;
//    private final T element;
//
//    public Timestamp() {
//        this.time = LocalDateTime.now();
//        this.element = null;
//    }
//
//    public Timestamp(LocalDateTime time) {
//        this.time = time;
//        this.element = null;
//    }
//
//    public Timestamp(LocalDateTime time, T element) {
//        this.time = time;
//        this.element = element;
//    }
//
//    public LocalDateTime getTime() {
//        return time;
//    }
//
//    public T getElement() {
//        return element;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Timestamp<?> timestamp = (Timestamp<?>) o;
//        return Objects.equals(time, timestamp.time) && Objects.equals(element, timestamp.element);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(time, element);
//    }
//
//    @Override
//    public int compareTo(Timestamp<T> o) {
//        if (getTime().isBefore(o.getTime()))
//            return -1;
//        if (getTime().isAfter(o.getTime()))
//            return 1;
//        return 0;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s %s", this.time.toString(), this.element.toString());
//    }
//}
