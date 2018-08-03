package t08_ObjectCommunicationAndEvents.p03_DependencyInversion.core;

import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.strategies.*;

import java.util.Map;

public class PrimitiveCalculator implements Calculator {

    private static final Map<Character, Strategy> allStrategies = Map.of(
            '+', new AdditionStrategy(),
            '-', new SubtractionStrategy(),
            '*', new MultiplicationStrategy(),
            '/', new DivisionStrategy()
    );

    private Strategy strategy;


    public PrimitiveCalculator() {
        this.strategy = allStrategies.get('+');
    }

    @Override
    public void changeStrategy(char operator) {
        this.strategy = allStrategies.get(operator);
    }

    @Override
    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
