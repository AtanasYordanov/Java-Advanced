package t06_ExamPreparation.Exam_08_05_2017.model;

import t06_ExamPreparation.Exam_08_05_2017.model.cells.Cell;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.bloodCells.BloodCell;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.microbes.Microbe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    public void activate() {
        if (this.cells.size() > 1) {
            this.cells.sort(Comparator.comparing(Cell::getPositionRow).thenComparing(Cell::getPositionCol));
            Cell movingCell = this.cells.get(0);

            while (this.cells.size() > 1) {
                Cell nextCell = cells.get(1);
                int row = nextCell.getPositionRow();
                int col = nextCell.getPositionCol();
                if (movingCell instanceof BloodCell) {
                    ((BloodCell) movingCell).assimilate(nextCell);
                    cells.remove(1);
                } else if (movingCell instanceof Microbe) {
                    if (this.firstCellWins(movingCell, nextCell)) {
                        this.cells.remove(1);
                    } else {
                        this.cells.remove(0);
                        movingCell = nextCell;
                    }
                }
                movingCell.setPositionRow(row);
                movingCell.setPositionCol(col);
            }
        }
    }

    private boolean firstCellWins(Cell firstCell, Cell secondCell) {
        while (true) {
            firstCell.attack(secondCell);
            if (secondCell.getHealth() <= 0) {
                return true;
            }
            secondCell.attack(firstCell);
            if (firstCell.getHealth() <= 0) {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        this.cells.sort(Comparator.comparing(Cell::getPositionRow).thenComparing(Cell::getPositionCol));
        StringBuilder sb = new StringBuilder();
        sb.append("----Cluster ").append(this.id);
        for (Cell cell : this.cells) {
            sb.append(System.lineSeparator()).append(cell);
        }
        return sb.toString();
    }
}
