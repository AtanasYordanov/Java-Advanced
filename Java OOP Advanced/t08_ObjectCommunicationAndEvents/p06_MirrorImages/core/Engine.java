package t08_ObjectCommunicationAndEvents.p06_MirrorImages.core;

import t08_ObjectCommunicationAndEvents.p06_MirrorImages.io.Reader;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.io.Writer;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.model.Wizard;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.repository.WizardRepository;

import java.io.IOException;

public class Engine {

    private Writer writer;
    private Reader reader;
    private WizardRepository wizardRepository;

    public Engine(Writer writer, Reader reader, WizardRepository wizardRepository) {
        this.writer = writer;
        this.reader = reader;
        this.wizardRepository = wizardRepository;
    }

    public void run() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        String name = tokens[0];
        int magicalPower = Integer.parseInt(tokens[1]);
        Wizard wizard = new Wizard(name, magicalPower, this.wizardRepository);
        this.wizardRepository.addWizard(wizard);

        for (String line = this.reader.readLine(); !line.equals("END"); line = this.reader.readLine()) {
            tokens = line.split("\\s+");
            int wizardId = Integer.parseInt(tokens[0]);
            String spell = tokens[1];
            Wizard wiz = this.wizardRepository.getWizardById(wizardId);
            if (spell.equals("FIREBALL")) {
                this.writer.write(wiz.castFireBall());
            } else {
                this.writer.write(wiz.castReflection());
            }
        }
    }
}
