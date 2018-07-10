package t01_Generics.p04_GenericSwapMethodIntegers;

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

    public void swapElements(int firstIndex, int secondIndex) {
        T temp = this.box.get(firstIndex);
        this.box.set(firstIndex, box.get(secondIndex));
        this.box.set(secondIndex, temp);
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
