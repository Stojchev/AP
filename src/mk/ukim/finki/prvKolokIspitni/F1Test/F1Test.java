package mk.ukim.finki.prvKolokIspitni.F1Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class F1Test {

    public static void main(String[] args) throws IOException {
        F1Race f1Race = new F1Race();
        f1Race.readResults(System.in);
        f1Race.printSorted(System.out);
    }

}

class F1Race {
    private ArrayList<F1Racer> racers;

    public F1Race() {
        this.racers = new ArrayList<>();
    }

    public void addRacer(String name, String[] races) {
        racers.add(new F1Racer(name, races));
    }

    public void readResults(InputStream in) throws IOException {
        Scanner scanner = new Scanner(in);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] splitedLine = line.split(" ");
            String name = splitedLine[0];
            String[] races = new String[splitedLine.length-1];
            for(int i=0;i<splitedLine.length-1;i++){
                races[i]=splitedLine[i+1];
            }
            addRacer(name, races);
        }

    }

    public void sortByBestLap() {
        for(int i=0;i<racers.size()-1;i++){
            if(racers.get(i).bestRace().compareTo(racers.get(i+1).bestRace())>0){
                Collections.swap(racers,i,i+1);
                i=-1;
            }
        }
    }

    public void printSorted(PrintStream out) {
        int count=0;
        sortByBestLap();
        PrintWriter writer = new PrintWriter(out);
        for (F1Racer racer : racers) {
            writer.write(++count+". ");
            writer.write(racer.toString());
            writer.write("\n");
        }
        writer.flush();
        writer.close();

    }
}

class F1Racer {
    private String name;
    private ArrayList<String> laps;


    public F1Racer(String name, String[] laps) {
        this.laps = new ArrayList<>();
        this.name = name;
        this.laps.addAll(Arrays.asList(laps));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLaps(String[] laps) {
        this.laps.addAll(Arrays.asList(laps));
    }

    public String bestRace() {
        String bestLap = laps.get(0);
        for (String lap : laps) {
            if(bestLap.compareTo(lap)>0)
                bestLap=lap;
        }
        return bestLap;
    }

    @Override
    public String toString() {
        return String.format("%-11s %s",name,bestRace());
    }
}