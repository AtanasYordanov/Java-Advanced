package panzer.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;

public class AssemblerTests {

    private static final double INPUT_WEIGHT = 100.0;
    private static final BigDecimal INPUT_PRICE = BigDecimal.TEN;
    private static final int INPUT_MODIFIER = 100;

    private static final double EXPECTED_TOTAL_WEIGHT = 300.0;
    private static final BigDecimal EXPECTED_TOTAL_PRICE = BigDecimal.valueOf(30);
    private static final int EXPECTED_TOTAL_MODIFIER = 100;

    private AttackModifyingPart arsenalPartMock;
    private DefenseModifyingPart shellPartMock;
    private HitPointsModifyingPart endurancePartMock;
    private Assembler assembler;

    @Before
    public void initialize() {
        this.assembler = new VehicleAssembler();
        this.arsenalPartMock =  Mockito.mock(AttackModifyingPart.class);
        this.shellPartMock =  Mockito.mock(DefenseModifyingPart.class);
        this.endurancePartMock =  Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addArsenalPart(arsenalPartMock);
        this.assembler.addShellPart(shellPartMock);
        this.assembler.addEndurancePart(endurancePartMock);
    }


    @Test
    public void getTotalWeight_whenPartsArePresent_shouldReturnCorrectValue() {
        Mockito.when(arsenalPartMock.getWeight()).thenReturn(INPUT_WEIGHT);
        Mockito.when(shellPartMock.getWeight()).thenReturn(INPUT_WEIGHT);
        Mockito.when(endurancePartMock.getWeight()).thenReturn(INPUT_WEIGHT);

        double result = this.assembler.getTotalWeight();

        Assert.assertEquals(EXPECTED_TOTAL_WEIGHT, result, 0.0);
    }

    @Test
    public void getTotalPrice_whenPartsArePresent_shouldReturnCorrectValue() {
        Mockito.when(arsenalPartMock.getPrice()).thenReturn(INPUT_PRICE);
        Mockito.when(shellPartMock.getPrice()).thenReturn(INPUT_PRICE);
        Mockito.when(endurancePartMock.getPrice()).thenReturn(INPUT_PRICE);

        BigDecimal result = this.assembler.getTotalPrice();

        Assert.assertEquals(EXPECTED_TOTAL_PRICE, result);
    }

    @Test
    public void getTotalAttackModification_whenTotalAttackBiggerThanInt_shouldWorkCorrectly() {
        AttackModifyingPart mockAttModify = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(mockAttModify);
        Mockito.when(mockAttModify.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.arsenalPartMock.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        long actual = this.assembler.getTotalAttackModification();
        long expected = Integer.MAX_VALUE * 2L;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalDefenseModification_whenTotalAttackBiggerThanInt_shouldWorkCorrectly() {
        DefenseModifyingPart mockDefModify = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(mockDefModify);
        Mockito.when(mockDefModify.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.shellPartMock.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        long actual = this.assembler.getTotalDefenseModification();
        long expected = Integer.MAX_VALUE * 2L;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalHitPointModification_whenTotalAttackBiggerThanInt_shouldWorkCorrectly() {
        HitPointsModifyingPart mockHitPtModify = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(mockHitPtModify);
        Mockito.when(mockHitPtModify.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.endurancePartMock.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        long actual = this.assembler.getTotalHitPointModification();
        long expected = Integer.MAX_VALUE * 2L;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addArsenalPart_whenCalled_shouldWorkCorrectly() {
        AttackModifyingPart mock = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(mock.getAttackModifier()).thenReturn(INPUT_MODIFIER);
        Mockito.when(this.arsenalPartMock.getAttackModifier()).thenReturn(INPUT_MODIFIER);
        this.assembler.addArsenalPart(mock);

        long actualAttack = this.assembler.getTotalAttackModification();

        Assert.assertEquals(EXPECTED_TOTAL_MODIFIER * 2, actualAttack);
    }

    @Test
    public void addShellPart_whenCalled_shouldWorkCorrectly() {
        DefenseModifyingPart mock = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(mock.getDefenseModifier()).thenReturn(INPUT_MODIFIER);
        Mockito.when(this.shellPartMock.getDefenseModifier()).thenReturn(INPUT_MODIFIER);
        this.assembler.addShellPart(mock);

        long actualDefense = this.assembler.getTotalDefenseModification();

        Assert.assertEquals(EXPECTED_TOTAL_MODIFIER * 2, actualDefense);
    }

    @Test
    public void addEndurancePart_whenCalled_shouldWorkCorrectly() {
        HitPointsModifyingPart mock = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(mock.getHitPointsModifier()).thenReturn(INPUT_MODIFIER);
        Mockito.when(this.endurancePartMock.getHitPointsModifier()).thenReturn(INPUT_MODIFIER);
        this.assembler.addEndurancePart(mock);

        long actualHitPoints = this.assembler.getTotalHitPointModification();

        Assert.assertEquals(EXPECTED_TOTAL_MODIFIER * 2, actualHitPoints);
    }
}
