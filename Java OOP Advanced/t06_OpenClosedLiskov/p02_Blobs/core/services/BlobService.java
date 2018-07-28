package t06_OpenClosedLiskov.p02_Blobs.core.services;

import t06_OpenClosedLiskov.p02_Blobs.core.repositories.BlobRepository;
import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public class BlobService {
    private BlobRepository blobRepository;

    public BlobService(BlobRepository blobRepository) {
        this.blobRepository = blobRepository;
    }

    public void addBlob(Blob blob) {
        this.blobRepository.addBlob(blob);
    }

    public Blob getBlobByName(String name) {
        return this.blobRepository.getBlobByName(name);
    }

    public void updateBlobs() {
        this.blobRepository.getAll().forEach(Blob::update);
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        this.blobRepository.getAll().forEach(b -> sb.append(b).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
