package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces;

public interface Subject {
    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyAllObservers();
}
