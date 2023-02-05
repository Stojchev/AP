package mk.ukim.finki.vtorKolokviumIspitni.FootballTableTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class FootballTeam {
    private String name;
    private int games;
    private int wins;
    private int draws;
    private int loses;

    private int goalsReceived;
    private int goalsGiven;


    public FootballTeam(String name) {
        this.name = name;
        this.games = 0;
        this.wins = 0;
        this.draws = 0;
        this.loses = 0;
        this.goalsReceived = 0;
        this.goalsGiven = 0;

    }

    public int getGoalsAverage() {
        return goalsGiven-goalsReceived;
    }

    public void addGoalsGiven(int goalsToAdd) {
        this.goalsGiven += goalsToAdd;
    }

    public void addGoalsReceived(int goalsToAdd) {
        this.goalsReceived += goalsToAdd;
    }

    public int getPoints() {
        return 3 * wins + draws;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGames() {
        this.games++;
    }

    public void addWin() {
        this.wins++;
        addGames();
    }

    public void addDraw() {
        this.draws++;
        addGames();
    }

    public void addLoss() {
        this.loses++;
        addGames();
    }

    public String getName() {
        return name;
    }

    public int getGames() {
        return games;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLoses() {
        return loses;
    }

    @Override
    public String toString() {
        return name;
    }
}


class FootballTable {
    Map<String, FootballTeam> footballTeams;

    public FootballTable() {
        this.footballTeams = new TreeMap<>();
    }

    public void addGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        footballTeams.putIfAbsent(homeTeam, new FootballTeam(homeTeam));
        footballTeams.putIfAbsent(awayTeam, new FootballTeam(awayTeam));
        if (homeGoals == awayGoals) {
            footballTeams.get(homeTeam).addDraw();
            footballTeams.get(awayTeam).addDraw();
        } else if (homeGoals > awayGoals) {
            footballTeams.get(homeTeam).addWin();
            footballTeams.get(awayTeam).addLoss();
        } else {
            footballTeams.get(homeTeam).addLoss();
            footballTeams.get(awayTeam).addWin();
        }
        footballTeams.get(homeTeam).addGoalsGiven(awayGoals);
        footballTeams.get(homeTeam).addGoalsReceived(homeGoals);
        footballTeams.get(awayTeam).addGoalsGiven(homeGoals);
        footballTeams.get(awayTeam).addGoalsReceived(awayGoals);
    }

    public void printTable() {
        Comparator<FootballTeam> comparator = Comparator.comparing(FootballTeam::getPoints).thenComparing(FootballTeam::getGoalsAverage);
        int counter = 1;
        for (FootballTeam tmp : footballTeams.values().stream().sorted(comparator.reversed()).collect(Collectors.toList())) {
            System.out.printf("%2d. %-17s %2d %4d %4d %4d %4d\n", counter++, tmp.getName(), tmp.getGames(), tmp.getWins(), tmp.getDraws(), tmp.getLoses(), tmp.getPoints());
        }
    }
}


public class FootballTableTest {
    public static void main(String[] args) throws IOException {
        FootballTable table = new FootballTable();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines()
                .map(line -> line.split(";"))
                .forEach(parts -> table.addGame(parts[0], parts[1],
                        Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3])));
        reader.close();
        System.out.println("=== TABLE ===");
        System.out.printf("%-19s%5s%5s%5s%5s%5s\n", "Team", "P", "W", "D", "L", "PTS");
        table.printTable();
    }
}

// Your code here

