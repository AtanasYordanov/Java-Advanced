package app.model.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class WarriorTests {

    private Hero warrior;

    @Before
    public void initialize() {
        this.warrior = new Warrior();
    }

    @Test
    public void takeDamage_whenCalled_shouldReduceHealthByDamageAmount() {
        this.warrior.takeDamage(10);
        Assert.assertEquals(40d, warrior.getHealth(), 0.0);
    }

    @Test
    public void isAlive_whenWarriorIsAlive_shouldReturnTrue() {
        Assert.assertTrue(this.warrior.isAlive());
    }

    @Test
    public void isAlive_whenWarriorIsDead_shouldReturnFalse() {
        this.warrior.setHealth(0);

        Assert.assertFalse(this.warrior.isAlive());
    }

    @Test
    public void levelUp_whenCalled_shouldDoubleStrength() {
        this.warrior.levelUp();

        Assert.assertEquals(Config.WARRIOR_BASE_STRENGTH * 2, this.warrior.getStrength());
    }

    @Test
    public void levelUp_whenCalled_shouldDoubleDexterity() {
        this.warrior.levelUp();

        Assert.assertEquals(Config.WARRIOR_BASE_DEXTERITY * 2, this.warrior.getDexterity());
    }

    @Test
    public void levelUp_whenCalled_shouldDoubleIntelligence() {
        this.warrior.levelUp();

        Assert.assertEquals(Config.WARRIOR_BASE_INTELLIGENCE * 2, this.warrior.getIntelligence());
    }

    @Test
    public void levelUp_whenCalled_shouldSetHealthToMax() {
        this.warrior.setHealth(10);
        this.warrior.levelUp();
        Assert.assertEquals(100d, this.warrior.getHealth(), 0.0);
    }

    @Test
    public void giveReward_whenCalled_shouldGiveRewardEqualToGoldAmount() {
        double reward = this.warrior.getGold();
        Targetable mockTarget = Mockito.mock(Targetable.class);

        this.warrior.giveReward(mockTarget);

        Mockito.verify(mockTarget).receiveReward(reward);
    }


    @Test
    public void receiveReward_whenCalled_shouldIncreaseGoldByGivenAmount() {
        double rewardAmount = 100;
        this.warrior.receiveReward(rewardAmount);

        Assert.assertEquals(Config.HERO_START_GOLD + rewardAmount, this.warrior.getGold(), 0.0);
    }
}
