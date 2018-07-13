package t02_IteratorsAndComparators.p01_ListyIterator;

public class ListyIterator<T> {
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
}
