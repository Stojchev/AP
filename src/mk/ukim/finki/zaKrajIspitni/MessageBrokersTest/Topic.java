package mk.ukim.finki.zaKrajIspitni.MessageBrokersTest;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Topic implements Comparable<Topic> {
    private int partition;
    private String name;
    private Set<Message> partions;

    public Topic(int partition, String name) {
        this.partition = partition;
        this.name = name;
        this.partions = new TreeSet<>();
    }

    public void addMessage(Message message) throws PartitionDoesNotExistException {
        message.setPartition(PartitionAssigner.assignPartition(message, partition));
//        if (message.getPartition() != partition)
//            throw new PartitionDoesNotExistException(message.getPartition());
        partions.add(message);
    }

    public void changeNumberOfPartitions(int newPartitionsNumber) throws UnsupportedOperationException {
        if (newPartitionsNumber < partition)
            throw new UnsupportedOperationException();
        partition = newPartitionsNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Topic: %10s Partitions: %5d\\n", name, partions.size()));
        partions.forEach(i->sb.append("\n").append(i));
        return sb.toString();
    }

    @Override
    public int compareTo(Topic o1) {
        return name.compareTo(o1.name);
    }
}
