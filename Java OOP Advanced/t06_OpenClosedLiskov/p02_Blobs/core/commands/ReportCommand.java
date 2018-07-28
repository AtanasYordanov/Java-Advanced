package t06_OpenClosedLiskov.p02_Blobs.core.commands;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReportCommand implements Executable {

    @Override
    public void execute(String[] args) {
        Class<Blob> blobClass = Blob.class;
        Field[] fields = blobClass.getDeclaredFields();
        Field reportField = Arrays.stream(fields)
                .peek(f -> f.setAccessible(true))
                .filter(f -> f.getName().equals("shouldReport"))
                .findFirst()
                .orElseThrow();

        try {
            reportField.set(null, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
