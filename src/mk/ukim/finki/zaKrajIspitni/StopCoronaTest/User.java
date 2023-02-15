package mk.ukim.finki.zaKrajIspitni.StopCoronaTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String ID;
    String name;
    List<ILocation> iLocation;

    public User(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setiLocation(List<ILocation> iLocation) {
        this.iLocation = iLocation;
    }

    public void deleteNewCase(LocalDateTime timestamp) {
        int i = 0;
        for (ILocation location : iLocation) {
            if (location.getTimestamp().equals(timestamp)) {
                i++;
                break;
            }
        }
        iLocation.remove(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ID).append(" ").append(name).append("\n");
//        sb.append("Direct contacts:\n");
////        iLocation.forEach(iLocation1 -> {
////            sb.append(iLocation1.).append("\n");
////        });
        return sb.toString();
    }

    public Map<User, Integer> checkForCloseFriend(User u) {
        int count = 0;
        Map<User, Integer> userByDirectContact = new HashMap<>();
        for (ILocation location1 : iLocation) {
            for (ILocation location2 : u.iLocation) {
                if (!u.getID().equals(ID)) break;
                if (Math.sqrt(Math.pow(location1.getLatitude() - location2.getLatitude(), 2)
                        + Math.pow(location1.getLongitude() - location2.getLongitude(), 2)) <= 2.0 &&
                        Math.abs(Duration.between(location1.getTimestamp(), location2.getTimestamp()).getSeconds()) <= 300) {
                    count++;
                }
            }
            userByDirectContact.put(u, count);
            count = 0;
        }
        return userByDirectContact;
    }

}
