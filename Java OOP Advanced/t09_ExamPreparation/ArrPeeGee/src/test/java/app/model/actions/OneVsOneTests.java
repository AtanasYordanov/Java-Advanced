package app.model.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.actions.OneVsOne;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OneVsOneTests {

    private Action action;

    @Before
    public void initialize() {
        this.action = new OneVsOne();
    }

    @Test
    public void execute_whenGivenLessThanTwoParticipants_shouldReturnErrorMessage() {
        String result = this.action.executeAction(new ArrayList<>());
        Assert.assertEquals("There should be exactly 2 participants for OneVsOne!", result);
    }

    @Test
    public void execute_whenGivenMoreThanTwoParticipants_shouldReturnErrorMessage() {
        List<Targetable> list = List.of(new Warrior(), new Warrior(), new Warrior());
        String result = this.action.executeAction(list);
        Assert.assertEquals("There should be exactly 2 participants for OneVsOne!", result);
    }

    @Test
    public void execute_whenCalled_shouldDetermineCorrectWinner() {
        Warrior winner = Mockito.mock(Warrior.class);
        Warrior loser = Mockito.mock(Warrior.class);
        Mockito.when(winner.isAlive()).thenReturn(true);
        Mockito.when(loser.isAlive()).thenReturn(false);
        Mockito.when(winner.getName()).thenReturn("Gosho");
        List<Targetable> participants = List.of(winner, loser);

        String result = this.action.executeAction(participants).trim();

        Assert.assertTrue(result.contains("Gosho"));
    }

    @Test
    public void execute_whenCalled_winnerShouldLevelUp() {
        Warrior winner = Mockito.mock(Warrior.class);
        Warrior loser = Mockito.mock(Warrior.class);
        Mockito.when(winner.isAlive()).thenReturn(true);
        Mockito.when(loser.isAlive()).thenReturn(false);
        List<Targetable> participants = List.of(winner, loser);

        this.action.executeAction(participants);

        Mockito.verify(winner).levelUp();
    }

    @Test
    public void execute_whenCalled_loserMustNotLevelUp() {
        Warrior winner = Mockito.mock(Warrior.class);
        Warrior loser = Mockito.mock(Warrior.class);
        Mockito.when(winner.isAlive()).thenReturn(true);
        Mockito.when(loser.isAlive()).thenReturn(false);
        List<Targetable> participants = List.of(winner, loser);

        this.action.executeAction(participants);

        Mockito.verify(loser, Mockito.never()).levelUp();
    }
}
