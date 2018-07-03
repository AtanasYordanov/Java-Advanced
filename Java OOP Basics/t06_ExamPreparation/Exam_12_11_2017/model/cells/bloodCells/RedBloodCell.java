package t06_ExamPreparation.Exam_08_05_2017.model.cells.bloodCells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    public int getVelocity() {
        return this.velocity;
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("%n--------Health: %d | Velocity: %d | Energy: %d"
                        , super.getHealth(), this.velocity, this.getEnergy());
    }
}
