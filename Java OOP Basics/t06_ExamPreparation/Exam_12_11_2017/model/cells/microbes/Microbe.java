package t06_ExamPreparation.Exam_08_05_2017.model.cells.microbes;

import t06_ExamPreparation.Exam_08_05_2017.model.cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("%n--------Health: %d | Virulence: %d | Energy: %d"
                        , super.getHealth(), this.virulence, this.getEnergy());
    }
}
