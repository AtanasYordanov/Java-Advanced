package t01_Generics.p01_GenericBox;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T> {
    List<T> box;

    public GenericBox() {
        this.box = new ArrayList<>();
    }

    public void add(T item) {
        this.box.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this.box) {
            sb.append(item.getClass().getCanonicalName())
                    .append(": ")
                    .append(item)
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
