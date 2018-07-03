package t06_ExamPreparation.Exam_08_05_2017.model.cells;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public abstract int getEnergy();

    public void attack(Cell secondCell) {
        secondCell.setHealth(secondCell.getHealth() - this.getEnergy());
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]"
                , this.id, this.positionRow, this.positionCol);
    }
}

