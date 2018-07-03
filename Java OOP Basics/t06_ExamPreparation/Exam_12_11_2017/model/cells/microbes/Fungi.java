package t06_ExamPreparation.Exam_08_05_2017.model.cells.microbes;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return (super.getHealth() + super.getVirulence()) / 4;
    }
}
