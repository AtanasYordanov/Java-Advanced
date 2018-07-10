package t01_Generics.p06_GenericCountMethodIntegers;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T extends Comparable<T>> {
    List<T> box;

    public GenericBox() {
        this.box = new ArrayList<>();
    }

    public void add(T item) {
        this.box.add(item);
    }

    public void swapElements(int firstIndex, int secondIndex) {
        T temp = this.box.get(firstIndex);
        this.box.set(firstIndex, this.box.get(secondIndex));
        this.box.set(secondIndex, temp);
    }

    public int getGreaterElementsCount(T element) {
        int count = 0;
        for (T item : this.box) {
            if (item.compareTo(element) > 0) count++;
        }
        return count;
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
