package t01_Generics.p07_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T item) {
        this.list.add(item);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.list.get(firstIndex);
        this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temp);
    }

    public int getGreaterElementsCount(T element) {
        int count = 0;
        for (T item : this.list) {
            if (item.compareTo(element) > 0) count++;
        }
        return count;
    }

    public T getMax() {
        return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this.list) {
            sb.append(item).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
