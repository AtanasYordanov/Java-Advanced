package t08_ObjectCommunicationAndEvents.p07_1984.interfaces;

import t08_ObjectCommunicationAndEvents.p07_1984.model.Change;

public interface Subject {
    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyAllObservers(Change change);
}
