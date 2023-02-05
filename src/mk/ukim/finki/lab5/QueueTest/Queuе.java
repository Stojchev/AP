package mk.ukim.finki.lab5.QueueTest;
//
//public class Queuе<T> {
//    private Node<T> first;
//    private Node<T> last;
//    private int count;
//
//    public Queuе() {
//        first = null;
//        last = null;
//        count = 0;
//    }
//
//    public void enqueue(T element) {
//        if (count == 0) {
//            first = last = new Node<>(element, null);
//        } else {
//            last.setNext(new Node<>(element, null));
//            last = last.getNext();
//        }
//        count++;
//    }
//
//    public T dequeue() throws EmptyQueueException {
//        if (count == 0)
//            throw new EmptyQueueException();
//        T tmp = first.getNext().getElement();
//        first = first.getNext();
//        return tmp;
//    }
//
//    public T inspect() throws EmptyQueueException {
//        if (count == 0)
//            throw new EmptyQueueException();
//        return first.getElement();
//    }
//
//    public int count() {
//        return count;
//    }
//}
