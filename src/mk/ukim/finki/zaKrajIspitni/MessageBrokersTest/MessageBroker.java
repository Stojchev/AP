package mk.ukim.finki.zaKrajIspitni.MessageBrokersTest;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MessageBroker {
    Set<Topic> topics;
    LocalDateTime minimumDate;
    Integer capacityPerTopic;

    public MessageBroker(LocalDateTime minimumDate, Integer capacityPerTopic) {
        this.minimumDate = minimumDate;
        this.capacityPerTopic = capacityPerTopic;
        this.topics = new TreeSet<>();
    }

    public void addTopic(String topicName, int partitionsCount) {
        topics.add(new Topic(partitionsCount, topicName));
    }

    public void addMessage(String topic, Message message) throws PartitionDoesNotExistException {
        topics.stream().filter(i -> i.getName().equals(topic)).forEach(j -> {
            try {
                j.addMessage(message);
            } catch (PartitionDoesNotExistException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void changeTopicSettings(String topicName, Integer partitions) {
        topics.stream().filter(i -> i.getName().equals(topicName)).forEach(j -> {
            try {
                j.changeNumberOfPartitions(partitions);
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(topics.size());
        topics.forEach(i->sb.append("\n").append(i));
        return sb.toString();
    }
}
