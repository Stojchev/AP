package mk.ukim.finki.lab5.QueueTest;
//
//class Queue<T> {
//    private Node<T> first;
//    private Node<T> last;
//    private int count;
//
//    public void Queue() {
//        first = null;
//        last = null;
//        count = 0;
//    }
//
//    public boolean isEmpty(){
//        return count == 0;
//    }
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
//        if (isEmpty())
//            throw new EmptyQueueException();
//        T tmp = first.getElement();
//        first = first.getNext();
//        count--;
//        return tmp;
//    }
//    public T peek() throws EmptyQueueException {
//        if (isEmpty())
//            throw new EmptyQueueException();
//        return first.getElement();
//    }
//    public T inspect() throws EmptyQueueException {
//        if (isEmpty())
//            throw new EmptyQueueException();
//        return last.getElement();
//    }
//
//    public int count() {
//        return count;
//    }
//}