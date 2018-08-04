package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.BaseHero;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {

    @Override
    public String executeAction(List<Targetable> participants) {
        List<Targetable> heroes = participants.stream()
                .filter(Targetable::isAlive)
                .filter(p -> !p.getClass().getSimpleName().equals("Boss"))
                .collect(Collectors.toList());

        if (participants.size() < 1) {
            return "There should be at least 1 participant for boss fight!";
        }
        Targetable boss = participants.get(0);

        if (boss instanceof BaseHero) {
            return "Invalid boss.";
        }
        StringBuilder sb = new StringBuilder();

        while (boss.isAlive() && heroes.size() > 0) {
            for (int i = 0; i < heroes.size(); i++) {
                Targetable participant = heroes.get(i);
                if (participant.isAlive()) {
                    participant.attack(boss);
                } else {
                    heroes.remove(i--);
                    continue;
                }

                if (!boss.isAlive()) {
                    break;
                }
                boss.attack(participant);
            }
        }
        if (boss.isAlive()) {
            sb.append("Boss has slain them all!");
            boss.levelUp();
        } else {
            sb.append("Boss has been slain by:").append(System.lineSeparator());
            heroes.sort(Comparator.comparing(Targetable::getName));
            for (Targetable participant : heroes) {
                participant.levelUp();
                participant.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                sb.append(participant).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
