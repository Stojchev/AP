package mk.ukim.finki.lab8.PatternTest;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//public class MP3Player {
//    private Set<Song> songs;
//    private Integer currentSong;
//    private boolean isPlaying;
//
//    public MP3Player(List<Song> listSongs) {
//        this.songs = new TreeSet<>();
//        this.songs = (Set<Song>) listSongs;
//        this.currentSong = 0;
//        this.isPlaying = false;
//    }
//
//    public void pressPlay() {
//        isPlaying = false;
//        printCurrentSong();
//    }
//
//    public void printCurrentSong() {
//        System.out.printf("Song %d is playing\n", currentSong);
//    }
//
//    public void pressStop() {
//        if (isPlaying) {
//            System.out.printf("Song %d is paused", currentSong);
//            isPlaying = false;
//        }
//        System.out.println("Songs are stopped");
//    }
//
//    public void pressFWD() {
//        currentSong++;
//        if (currentSong > songs.size() + 1)
//            currentSong = 0;
//    }
//
//    public void pressREW() {
//        currentSong--;
//        if (currentSong ==0)
//            currentSong = songs.size()+1;
//    }
//}
