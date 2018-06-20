package t06_ExamPreparation.Exam_05_01_2018.model;

import t06_ExamPreparation.Exam_05_01_2018.model.constants.Messages;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new HashMap<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public List<Colonist> getColonistsByFamilyId(String id) {
        return this.families.get(id).getColonists();
    }

    public void addColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();
        Family family = this.families.get(familyId);
        if (family == null) {
            if (this.maxFamilyCount <= this.families.size()) {
                throw new IllegalArgumentException(Messages.COLONY_IS_FULL);
            }
            family = new Family(familyId);
        }
        if (family.getColonists().size() == this.maxFamilyCapacity) {
            throw new IllegalArgumentException(Messages.FAMILY_IS_FULL);
        }
        family.addColonist(colonist);
        this.families.put(familyId, family);
    }

    public void removeColonist(String familyId, String colonistId) {
        Family family = this.families.get(familyId);
        if (family != null) {
            family.removeColonist(colonistId);
            if (family.getColonists().isEmpty()) {
                this.removeFamily(familyId);
            }
        }
    }

    public void removeFamily(String id) {
        this.families.remove(id);
    }

    public void grow(int years) {
        this.families.values().stream().flatMap(f -> f.getColonists().stream())
                .forEach(c -> c.grow(years));
    }

    public int getPotential() {
        return this.families.values().stream().flatMap(f -> f.getColonists().stream())
                .mapToInt(Colonist::getPotential).sum();
    }

    public Family getFamilyById(String familyId) {
        return this.families.get(familyId);
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d", this.families.size(), this.maxFamilyCount))
                .append(System.lineSeparator());
        this.families.values().stream()
                .sorted(Comparator.comparing(Family::getId))
                .forEach(family -> {
                    sb.append(String.format("-%s: %d/%d"
                            , family.getId()
                            , family.getColonists().size()
                            , this.getMaxFamilyCapacity()))
                            .append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}
