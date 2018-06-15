package t02_Encapsulation.p06_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            Team team;
            try {
                switch (command) {
                    case "Team":
                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "Add":
                        String playerToAdd = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        team = teams.get(teamName);
                        if (team == null) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                            break;
                        }
                        Player player = new Player(playerToAdd, team, endurance, sprint, dribble, passing, shooting);
                        team.addPlayer(player);
                        break;
                    case "Remove":
                        String playerToRemove = tokens[2];
                        team = teams.get(teamName);
                        team.removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        team = teams.get(teamName);
                        if (team == null) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                            break;
                        }
                        System.out.printf("%s - %.0f%n", teamName, team.getRating());
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
