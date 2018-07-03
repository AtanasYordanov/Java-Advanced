import t06_ExamPreparation.Exam_08_05_2017.model.HealthManager;
import t06_ExamPreparation.Exam_12_11_2017.constants.OrganismCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HealthManager healthManager = new HealthManager();
        for (String line = reader.readLine(); !line.equals(OrganismCommands.END_COMMAND); line = reader.readLine()) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String organismName = tokens[1];
            try {
                switch (command) {
                    case OrganismCommands.CREATE_ORGANISM:
                            System.out.println(healthManager.createOrganism(organismName));
                        break;
                    case OrganismCommands.CHECK_CONDITION:
                        System.out.println(healthManager.checkCondition(organismName));
                        break;
                    case OrganismCommands.ADD_CLUSTER:
                        String clusterId = tokens[2];
                        int rows = Integer.parseInt(tokens[3]);
                        int cols = Integer.parseInt(tokens[4]);
                        System.out.println(healthManager.addCluster(organismName, clusterId, rows, cols));
                        break;
                    case OrganismCommands.ADD_CELL:
                        clusterId = tokens[2];
                        String cellType = tokens[3];
                        String cellId = tokens[4];
                        int health = Integer.parseInt(tokens[5]);
                        int row = Integer.parseInt(tokens[6]);
                        int col = Integer.parseInt(tokens[7]);
                        int additionalProperty = Integer.parseInt(tokens[8]);
                        System.out.println(healthManager.addCell(organismName, clusterId, cellType, cellId, health, row, col, additionalProperty));
                        break;
                    case OrganismCommands.ACTIVATE_CLUSTER:
                        System.out.println(healthManager.activateCluster(organismName));
                        break;
                }
            } catch (IllegalArgumentException ignore) {
                ;
            }
        }
    }
}
