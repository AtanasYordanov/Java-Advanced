package t08_ObjectCommunicationAndEvents.p04_WorkForce.model;

import t08_ObjectCommunicationAndEvents.p04_WorkForce.interfaces.Observer;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.interfaces.Subject;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.io.Writer;

public class JobObserver implements Observer {

    private Writer writer;
    private Subject subject;

    public JobObserver(Writer writer, Subject subject) {
        this.writer = writer;
        this.subject = subject;
        subject.attachObserver(this);
    }

    @Override
    public void update() {
        this.writer.write(this.subject);
        this.subject.detachObserver(this);
    }
}
