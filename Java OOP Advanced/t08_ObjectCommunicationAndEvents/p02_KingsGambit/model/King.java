package t08_ObjectCommunicationAndEvents.p02_KingsGambit.model;

import t08_ObjectCommunicationAndEvents.p02_KingsGambit.interfaces.Attackable;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.interfaces.Observer;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.interfaces.Subject;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Writer;

import java.util.LinkedHashSet;
import java.util.Set;

public class King extends BaseUnit implements Attackable, Subject {

    private Set<Observer> observers;

    public King(String name, Writer writer) {
        super(name, writer);
        this.observers = new LinkedHashSet<>();
    }

    @Override
    public void takeAttack() {
        super.getWriter().write(String.format("King %s is under attack!", super.getName()));
        this.notifyAllObservers();
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : this.observers) {
            observer.respond();
        }
    }
}
