package t08_ObjectCommunicationAndEvents.p06_MirrorImages.repository;

import t08_ObjectCommunicationAndEvents.p06_MirrorImages.model.Wizard;

import java.util.ArrayList;
import java.util.List;

public class WizardRepository {
    private List<Wizard> wizards;

    public WizardRepository() {
        this.wizards = new ArrayList<>();
    }

    public void addWizard(Wizard wizard) {
        wizard.setId(this.wizards.size());
        this.wizards.add(wizard);
    }

    public Wizard getWizardById(int id) {
        return this.wizards.get(id);
    }
}
