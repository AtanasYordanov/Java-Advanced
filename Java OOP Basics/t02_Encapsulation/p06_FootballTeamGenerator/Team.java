package t02_Encapsulation.p06_FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

public class Team {
    private String name;
    private double rating;
    private Map<String, Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.matches("\\s+")) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
        return this.rating;
    }

    public void addPlayer(Player player) {
        this.players.put(player.getName(), player);
        this.updateRating();
    }

    public void removePlayer(String name) {
        if (!this.players.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
        this.players.remove(name);
        this.updateRating();
    }

    private void updateRating() {
        OptionalDouble skillLevel = this.players.values().stream()
                .mapToDouble(Player::getSkillLevel)
                .average();
        if (skillLevel.isPresent()) {
            this.rating = skillLevel.getAsDouble();
        } else {
            this.rating = 0d;
        }
    }
}
