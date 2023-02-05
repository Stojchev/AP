package mk.ukim.finki.lab7.ChatSystemTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.TreeSet;
import java.util.stream.Collectors;

class NoSuchRoomException extends Exception {
    public NoSuchRoomException(String userName) {
        System.out.println(userName);
    }
}

class ChatRoom {
    String name;
    Set<String> users;

    public ChatRoom(String name) {
        this.name = name;
        this.users = new TreeSet<>();
    }


    public void addUser(String user) {
        users.add(user);
    }

    public void removeUser(String user) {
        users.remove(user);
    }

    public boolean hasUser(String user) {
        return users.contains(user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("\n");
        if (users.isEmpty())
            sb.append("EMPTY");
        else
            sb.append(users.stream().collect(Collectors.joining("\n")));
        sb.append("\n");
        return sb.toString();
    }

    public int numUsers() {
        return users.size();
    }
}

class NoSuchRoomExcеption extends Exception {
    public NoSuchRoomExcеption(String roomName) {
        super("No such room " + roomName);
    }
}

class NoSuchUserException extends Exception {
    public NoSuchUserException(String userName) {
        super("No such user " + userName);
    }
}


class ChatSystem {
    Map<String, ChatRoom> rooms;
    Set<String> users;

    public ChatSystem() {
        this.rooms = new TreeMap<>();
        this.users = new TreeSet<>();
    }

    public void register(String userName) throws NoSuchUserException, NoSuchRoomExcеption {
        users.add(userName);
        if (!rooms.isEmpty()) {
            String min = rooms.values().stream()
                    .min(Comparator.comparing(ChatRoom::numUsers)).get().name;
            registerAndJoin(userName, min);
        }
    }

    public void registerAndJoin(String userName, String roomName) throws NoSuchUserException, NoSuchRoomExcеption {
        users.add(userName);
        joinRoom(userName, roomName);
    }

    public void joinRoom(String userName, String roomName) throws NoSuchUserException, NoSuchRoomExcеption {
        if (!rooms.containsKey(roomName))
            throw new NoSuchRoomExcеption(roomName);
        if (!users.contains(userName))
            throw new NoSuchUserException(userName);
        rooms.get(roomName).addUser(userName);
    }

    public void addRoom(String roomName) {
        rooms.put(roomName, new ChatRoom(roomName));
    }

    public void removeRoom(String roomName) {
        rooms.remove(roomName);
    }

    public ChatRoom getRoom(String userName) throws NoSuchRoomException {
        if (rooms.containsKey(userName))
            return rooms.get(userName);
        else throw new NoSuchRoomException(userName);
    }

    public void leaveRoom(String username, String roomName) throws NoSuchUserException, NoSuchRoomExcеption {
        if (!rooms.containsKey(roomName))
            throw new NoSuchRoomExcеption(roomName);
        if (!users.contains(username))
            throw new NoSuchUserException(username);
        rooms.get(roomName).removeUser(username);
    }

    public void followFriend(String username, String friend_username) throws NoSuchUserException {
        if (!users.contains(username))
            throw new NoSuchUserException(username);
        rooms.values().stream().filter(room -> room.hasUser(friend_username)).forEach(room -> room.addUser(username));
    }
}

public class ChatSystemTest {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchRoomException {
        Scanner jin = new Scanner(System.in);
        int k = jin.nextInt();
        if (k == 0) {
            ChatRoom cr = new ChatRoom(jin.next());
            int n = jin.nextInt();
            for (int i = 0; i < n; ++i) {
                k = jin.nextInt();
                if (k == 0) cr.addUser(jin.next());
                if (k == 1) cr.removeUser(jin.next());
                if (k == 2) System.out.println(cr.hasUser(jin.next()));
            }
            System.out.println("");
            System.out.println(cr.toString());
            n = jin.nextInt();
            if (n == 0) return;
            ChatRoom cr2 = new ChatRoom(jin.next());
            for (int i = 0; i < n; ++i) {
                k = jin.nextInt();
                if (k == 0) cr2.addUser(jin.next());
                if (k == 1) cr2.removeUser(jin.next());
                if (k == 2) cr2.hasUser(jin.next());
            }
            System.out.println(cr2.toString());
        }
        if (k == 1) {
            ChatSystem cs = new ChatSystem();
            Method mts[] = cs.getClass().getMethods();
            while (true) {
                String cmd = jin.next();
                if (cmd.equals("stop")) break;
                if (cmd.equals("print")) {
                    System.out.println(cs.getRoom(jin.next()) + "\n");
                    continue;
                }
                for (Method m : mts) {
                    if (m.getName().equals(cmd)) {
                        String params[] = new String[m.getParameterTypes().length];
                        for (int i = 0; i < params.length; ++i) params[i] = jin.next();
                        m.invoke(cs, params);
                    }
                }
            }
        }
    }

}
