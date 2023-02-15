package mk.ukim.finki.zaKrajIspitni.MessageBrokersTest;

import java.time.LocalDateTime;

public class Message implements Comparable<Message> {
    private LocalDateTime timestamp;
    private String message;
    private Integer partition;
    public String key;

    public Message(LocalDateTime timestamp, String message, Integer partition, String key) {
        this.timestamp = timestamp;
        this.message = message;
        this.partition = partition;
        this.key = key;
    }

    public Message(LocalDateTime timestamp, String message, String key) {
        this.timestamp = timestamp;
        this.message = message;
        //this.partition =PartitionAssigner.assignPartition() ;
        this.key = key;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    public Integer getPartition() {
        return partition;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int compareTo(Message o) {
        return timestamp.compareTo(o.getTimestamp());
    }
}
