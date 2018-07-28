package t06_OpenClosedLiskov.p02_Blobs.interfaces;

public interface Factory<T> {
    T getInstance(String name);
}
