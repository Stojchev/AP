package mk.ukim.finki.zaKrajIspitni.MessageBrokersTest;

public class PartitionDoesNotExistException extends Exception {
    public PartitionDoesNotExistException(int n) {
        System.out.println(String.format("The topic topic1 does not have a partition with number %d",n));

    }
}
