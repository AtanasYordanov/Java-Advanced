package t06_ExamPreparation.Exam_08_05_2017.model;

import t06_ExamPreparation.Exam_08_05_2017.constants.CellTypes;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.Cell;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.bloodCells.RedBloodCell;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.bloodCells.WhiteBloodCell;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.microbes.Bacteria;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.microbes.Fungi;
import t06_ExamPreparation.Exam_08_05_2017.model.cells.microbes.Virus;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> organisms = new LinkedHashMap<>();

    public String checkCondition(String organismName) {
        return this.organisms.get(organismName).toString();
    }

    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)) {
            return "Organism " + name + " already exists";
        }
        Organism organism = new Organism(name);
        this.organisms.put(name, organism);
        return "Created organism " + name;
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (!this.organisms.containsKey(organismName)) {
            throw new IllegalArgumentException();
        }
        Cluster cluster = new Cluster(id, rows, cols);
        this.organisms.get(organismName).addCluster(cluster);
        return String.format("Organism %s: Created cluster %s", organismName, id);
    }

    public String addCell(String organismName, String clusterId, String cellType
            , String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (!this.organisms.containsKey(organismName)) {
            throw new IllegalArgumentException();
        }
        Cluster cluster = this.organisms.get(organismName).getClusterById(clusterId);
        if (cluster == null) {
            throw new IllegalArgumentException();
        }
        Cell cell = null;
        switch (cellType) {
            case CellTypes.WHITE_BLOOD_CELL:
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CellTypes.RED_BLOOD_CELL:
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CellTypes.FUNGI:
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CellTypes.VIRUS:
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case CellTypes.BACTERIA:
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }
        cluster.addCell(cell);
        return String.format("Organism %s: Created cell %s in cluster %s"
                , organismName, cellId, clusterId);

    }

    public String activateCluster(String organismName) {
        if (!this.organisms.containsKey(organismName) || this.organisms.get(organismName).getClusters().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return this.organisms.get(organismName).activateCluster();
    }
}
