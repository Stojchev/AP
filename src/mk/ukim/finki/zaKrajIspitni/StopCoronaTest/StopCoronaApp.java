package mk.ukim.finki.zaKrajIspitni.StopCoronaTest;

import java.time.LocalDateTime;
import java.util.*;

public class StopCoronaApp {

    Map<String, User> usersById;

    public StopCoronaApp() {
        this.usersById = new TreeMap<>();
    }

    public void addUser(String name, String id) throws UserIdAlreadyExistsException {
        if (usersById.containsKey(id))
            throw new UserIdAlreadyExistsException();
        usersById.put(id, new User(name, id));
    }

    public void addLocations(String id, List<ILocation> locations) {
        usersById.get(id).setiLocation(locations);
    }

    public void detectNewCase(String id, LocalDateTime timestamp) {
        usersById.get(id).deleteNewCase(timestamp);
    }

    public void createReport() {
        //usersById.forEach((s, user) -> System.out.println(user.toString()));
        usersById.values().forEach(user -> {
            System.out.println(user.toString()+"\nDIRECT CONTACTS!\n");
            usersById.values().forEach(user1 -> {
                user.checkForCloseFriend(user1).keySet().forEach(cf -> {
                    System.out.println(cf.toString());
                });
            });
        });
    }

}
