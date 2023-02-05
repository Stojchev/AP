package mk.ukim.finki.lab7.ChatSystemTest;

import java.util.*;
import java.util.stream.Collectors;

//public class ChatSystem {
//    Map<String, ChatRoom> rooms;
//    Set<String> users;
//
//    public ChatSystem() {
//        this.rooms = new TreeMap<>();
//        this.users = new TreeSet<>();
//    }
//
//    public void register(String userName) throws NoSuchUserException, NoSuchRoomExcеption {
//        users.add(userName);
//        if (!rooms.isEmpty()) {
//            String min = rooms.values().stream()
//                    .min(Comparator.comparing(ChatRoom::numUsers).thenComparing(room -> room.name)).get().name;
//            registerAndJoin(userName, min);
//        }
//    }
//
//    public void registerAndJoin(String userName, String roomName) throws NoSuchUserException, NoSuchRoomExcеption {
//        users.add(userName);
//        joinRoom(userName, roomName);
//    }
//
//    public void joinRoom(String userName, String roomName) throws NoSuchUserException, NoSuchRoomExcеption {
//        if (!rooms.containsKey(roomName))
//            throw new NoSuchRoomExcеption(roomName);
//        if (!users.contains(userName))
//            throw new NoSuchUserException(userName);
//        rooms.get(roomName).addUser(userName);
//    }
//
//    public void addRoom(String roomName) {
//        rooms.put(roomName, new ChatRoom(roomName));
//    }
//
//    public void removeRoom(String roomName) {
//        rooms.remove(roomName);
//    }
//
//    public ChatRoom getRoom(String userName) throws NoSuchRoomException {
//        if (rooms.containsKey(userName))
//            return rooms.get(userName);
//        else throw new NoSuchRoomException(userName);
//    }
//
//    public void leaveRoom(String username, String roomName) throws NoSuchUserException, NoSuchRoomExcеption {
//        if (!rooms.containsKey(roomName))
//            throw new NoSuchRoomExcеption(roomName);
//        if (!users.contains(username))
//            throw new NoSuchUserException(username);
//        rooms.get(roomName).removeUser(username);
//    }
//    public void followFriend(String username, String friend_username) throws NoSuchUserException {
//        if(!users.contains(username))
//            throw new NoSuchUserException(username);
//        rooms.values().stream().filter(room -> room.hasUser(friend_username)).forEach(room -> room.addUser(username));
//    }
//}
