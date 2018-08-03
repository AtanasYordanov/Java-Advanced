package t08_ObjectCommunicationAndEvents.p07_1984.interfaces;

import t08_ObjectCommunicationAndEvents.p07_1984.model.Change;

public interface Observer {
    void logChange(Change change);

    void printLogs();

    void addSubject(String name);
}
