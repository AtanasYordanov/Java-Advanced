package t01_Generics.p11_Treeuple;

public class Tuple<T, E> {
    private T firstItem;
    private E secondItem;

    public Tuple(T firstItem, E secondItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }

    public T getFirstItem() {
        return this.firstItem;
    }

    public E getSecondItem() {
        return this.secondItem;
    }
}
