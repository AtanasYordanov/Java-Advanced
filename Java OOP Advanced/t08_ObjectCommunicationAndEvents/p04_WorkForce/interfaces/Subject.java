package t08_ObjectCommunicationAndEvents.p04_WorkForce.interfaces;

public interface Subject {
    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyAllObservers();

    String getName();
}
