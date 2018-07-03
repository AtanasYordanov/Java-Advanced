package t06_ExamPreparation.Exam_08_05_2017.model;

import t06_ExamPreparation.Exam_08_05_2017.model.benders.Bender;
import t06_ExamPreparation.Exam_08_05_2017.model.monuments.Monument;

import java.util.ArrayList;
import java.util.List;

public class Nation {
    private String element;
    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation(String element) {
        this.element = element;
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    public String getElement() {
        return this.element;
    }

    public List<Bender> getBenders() {
        return this.benders;
    }

    public List<Monument> getMonuments() {
        return this.monuments;
    }

    public double getTotalPower() {
        double bendersPower = this.benders.stream()
                .mapToDouble(Bender::getTotalPower)
                .sum();
        long monumentsPower = this.monuments.stream()
                .mapToLong(Monument::getAffinity)
                .sum();
        return bendersPower + bendersPower * monumentsPower / 100;
    }

    public void destroyBenders() {
        this.benders.clear();
    }

    public void destroyMonuments() {
        this.monuments.clear();
    }

    public void addBender(Bender bender) {
        this.benders.add(bender);
    }

    public void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.element).append(" Nation")
                .append(System.lineSeparator())
                .append("Benders:");
        if (!this.benders.isEmpty()) {
            for (Bender bender : this.benders) {
                sb.append(System.lineSeparator()).append("###").append(bender);
            }
        } else {
            sb.append(" None");
        }
        sb.append(System.lineSeparator());
        sb.append("Monuments:");
        if (!this.monuments.isEmpty()) {
            for (Monument monument : this.monuments) {
                sb.append(System.lineSeparator()).append("###").append(monument);
            }
        } else {
            sb.append(" None");
        }
        return sb.toString();
    }
}
