package t02_IteratorsAndComparators.p02_Collection;

import java.util.Iterator;

public class ListyIterator<T> implements Iterable<T> {
    private T[] items;
    private int pointer;

    public ListyIterator(T... items) {
        this.items = items;
    }

    public boolean move() {
        if (this.pointer < this.items.length - 1) {
            this.pointer++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.pointer < this.items.length - 1;
    }

    public void print() {
        if (this.items.length == 0 || this.pointer >= this.items.length) {
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(this.items[this.pointer]);
    }

    @SuppressWarnings("unchecked")
    public void printAll() {
        StringBuilder sb = new StringBuilder();
        for (T t : this) {
            sb.append(t).append(" ");
        }
        System.out.println(sb);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListyIteratorIterator();
    }

    private final class ListyIteratorIterator implements Iterator<T> {

        private int pointer;

        @Override
        public boolean hasNext() {
            return this.pointer < items.length;
        }

        @Override
        public T next() {
            T item = items[this.pointer];
            if (this.hasNext()) {
                this.pointer++;
            }
            return item;
        }
    }
}
