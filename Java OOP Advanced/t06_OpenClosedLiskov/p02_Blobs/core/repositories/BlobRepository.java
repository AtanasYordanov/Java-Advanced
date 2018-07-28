package t06_OpenClosedLiskov.p02_Blobs.core.repositories;

import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepository {
    private Map<String, Blob> blobs;

    public BlobRepository() {
        this.blobs = new LinkedHashMap<>();
    }

    public void addBlob(Blob blob) {
        this.blobs.put(blob.getName(), blob);
    }

    public Blob getBlobByName(String name) {
        return this.blobs.get(name);
    }

    public Iterable<Blob> getAll() {
        return this.blobs.values();
    }
}
