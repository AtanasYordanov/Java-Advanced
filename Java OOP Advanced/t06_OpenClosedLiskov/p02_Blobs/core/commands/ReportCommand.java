package t06_OpenClosedLiskov.p02_Blobs.core.commands;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

import java.lang.reflect.Field;

public class ReportCommand implements Executable {

    @Override
    public void execute(String[] args) {
        Class<Blob> blobClass = Blob.class;

        try {
            Field reportField = blobClass.getDeclaredField("shouldReport");
            reportField.setAccessible(true);
            reportField.set(null, true);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
