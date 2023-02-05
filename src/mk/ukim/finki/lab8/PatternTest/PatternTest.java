package mk.ukim.finki.lab8.PatternTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Song {
    String artist;
    String title;

    public Song(String title, String artist) {
        this.artist = artist;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Song{title=" + title + ", artist=" + artist + "}";
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}

class MP3Player {
    private List<Song> songs;
    private int currentSong;
    private boolean isPlaying;
    private boolean stoppedAll;

    public MP3Player(List<Song> listSongs) {
        this.songs = new ArrayList<>();
        this.songs.addAll(listSongs);
        this.currentSong = 0;
        this.isPlaying = false;
        this.stoppedAll = false;
    }

    public void pressPlay() {
        System.out.printf("Song %s playing\n", isPlaying ? "is already" : currentSong + " is");
        this.isPlaying = true;
    }

    public void printCurrentSong() {
        System.out.println("Song{title=" + songs.get(currentSong).getTitle() + ", artist=" + songs.get(currentSong).getArtist() + "}");
    }

    public void pressStop() {
        currentSong = 0;
        if (isPlaying) {
            System.out.printf("Song %d is paused\n", currentSong);
            isPlaying = false;
            stoppedAll = true;
        } else if (stoppedAll) {
            stoppedAll = false;
            System.out.println("Songs are stopped");
        } else System.out.println("Songs are already stopped");
    }

    public void pressFWD() {
        isPlaying = false;
        stoppedAll = true;
        if (currentSong == songs.size() - 1)
            currentSong = 0;
        else currentSong++;
        System.out.println("Forward...");
    }

    public void pressREW() {
        isPlaying = false;
        stoppedAll = true;
        if (currentSong == 0)
            currentSong = songs.size() - 1;
        else currentSong--;
        System.out.println("Reward...");
    }

    @Override
    public String toString() {
        String result = "MP3Player{currentSong = " + currentSong + ", songList = [";
        String songs = this.songs.stream()
                .map(Song::toString)
                .collect(Collectors.joining(", "));
        return result + songs + "]}";
    }
}

public class PatternTest {
    public static void main(String args[]) {
        List<Song> listSongs = new ArrayList<Song>();
        listSongs.add(new Song("first-title", "first-artist"));
        listSongs.add(new Song("second-title", "second-artist"));
        listSongs.add(new Song("third-title", "third-artist"));
        listSongs.add(new Song("fourth-title", "fourth-artist"));
        listSongs.add(new Song("fifth-title", "fifth-artist"));
        MP3Player player = new MP3Player(listSongs);


        System.out.println(player.toString());
        System.out.println("First test");


        player.pressPlay();
        player.printCurrentSong();
        player.pressPlay();
        player.printCurrentSong();

        player.pressPlay();
        player.printCurrentSong();
        player.pressStop();
        player.printCurrentSong();

        player.pressPlay();
        player.printCurrentSong();
        player.pressFWD();
        player.printCurrentSong();

        player.pressPlay();
        player.printCurrentSong();
        player.pressREW();
        player.printCurrentSong();


        System.out.println(player.toString());
        System.out.println("Second test");


        player.pressStop();
        player.printCurrentSong();
        player.pressStop();
        player.printCurrentSong();

        player.pressStop();
        player.printCurrentSong();
        player.pressPlay();
        player.printCurrentSong();

        player.pressStop();
        player.printCurrentSong();
        player.pressFWD();
        player.printCurrentSong();

        player.pressStop();
        player.printCurrentSong();
        player.pressREW();
        player.printCurrentSong();


        System.out.println(player.toString());
        System.out.println("Third test");


        player.pressFWD();
        player.printCurrentSong();
        player.pressFWD();
        player.printCurrentSong();

        player.pressFWD();
        player.printCurrentSong();
        player.pressPlay();
        player.printCurrentSong();

        player.pressFWD();
        player.printCurrentSong();
        player.pressStop();
        player.printCurrentSong();

        player.pressFWD();
        player.printCurrentSong();
        player.pressREW();
        player.printCurrentSong();


        System.out.println(player.toString());
    }
}

//Vasiot kod ovde