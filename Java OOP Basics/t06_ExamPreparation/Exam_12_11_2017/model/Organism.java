package t06_ExamPreparation.Exam_08_05_2017.model;

import java.util.*;

public class Organism {
    private String name;
    private Deque<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayDeque<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(new ArrayList<>(this.clusters));
    }

    public void addCluster(Cluster cluster) {
        this.clusters.offer(cluster);
    }

    public Cluster getClusterById(String id) {
        return this.clusters.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
    }

    public String activateCluster() {
        Cluster cluster = this.clusters.poll();
        cluster.activate();
        this.clusters.offer(cluster);
        return String.format("Organism %s: Activated cluster %s. Cells left: %d"
                , this.name, cluster.getId(), cluster.getCells().size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organism - ")
                .append(this.name)
                .append(System.lineSeparator())
                .append("--Clusters: ")
                .append(this.clusters.size())
                .append(System.lineSeparator())
                .append("--Cells: ")
                .append(this.clusters.stream().mapToInt(c -> c.getCells().size()).sum());
        for (Cluster cluster : this.clusters) {
            sb.append(System.lineSeparator()).append(cluster);
        }
        return sb.toString();
    }
}
