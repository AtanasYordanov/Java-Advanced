package t06_OpenClosedLiskov.p02_Blobs.interfaces;

import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public interface Behaviour {
    boolean isTriggered();

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);
}
