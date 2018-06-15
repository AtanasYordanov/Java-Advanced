package t02_Encapsulation.p06_FootballTeamGenerator;

public class Player {
    private String name;
    private Team team;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;
    private double skillLevel;

    public Player(String name, Team team, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setTeam(team);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
        this.setSkillLevel();
    }

    private void setSkillLevel() {
        this.skillLevel = (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5d;
    }

    public double getSkillLevel() {
        return this.skillLevel;
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

    private void setTeam(Team team) {
        this.team = team;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }
}
