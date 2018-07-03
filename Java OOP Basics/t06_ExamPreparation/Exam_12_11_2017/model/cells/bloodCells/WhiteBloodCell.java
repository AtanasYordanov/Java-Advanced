package t06_ExamPreparation.Exam_08_05_2017.model.cells.bloodCells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int getEnergy() {
        return (super.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("%n--------Health: %d | Size: %d | Energy: %d"
                        , super.getHealth(), this.size, this.getEnergy());
    }
}
