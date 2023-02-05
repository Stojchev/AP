package mk.ukim.finki.vtorKolokviumIspitni.FootballTableTest;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

//public class FootballTable {
//    Map<String, FootballTeam> footballTeams;
//
//    public void addGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
//        footballTeams.putIfAbsent(homeTeam, new FootballTeam(homeTeam));
//        footballTeams.putIfAbsent(awayTeam, new FootballTeam(awayTeam));
//        if (homeGoals == awayGoals) {
//            footballTeams.get(homeTeam).addDraw();
//            footballTeams.get(awayTeam).addDraw();
//        } else if (homeGoals > awayGoals) {
//            footballTeams.get(homeTeam).addWin();
//            footballTeams.get(awayTeam).addLoss();
//        } else {
//            footballTeams.get(homeTeam).addLoss();
//            footballTeams.get(awayTeam).addWin();
//        }
//    }
//
//    public void printTable() {
//        StringBuilder sb = new StringBuilder();
//        Comparator<FootballTeam> comparator = Comparator.comparing(FootballTeam::getPoints).thenComparing(FootballTeam::getName);
//        footballTeams.entrySet().stream().sorted().forEach(i-> System.out.println(i));
//    }
//}
