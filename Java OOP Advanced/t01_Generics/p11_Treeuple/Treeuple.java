package t01_Generics.p11_Treeuple;

public class Treeuple<T, E, R> {
    private T firstItem;
    private E secondItem;
    private R thirdItem;

    public Treeuple(T firstItem, E secondItem, R thirdItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
        this.thirdItem = thirdItem;
    }

    public T getFirstItem() {
        return this.firstItem;
    }

    public E getSecondItem() {
        return this.secondItem;
    }

    public R getThirdItem() {
        return this.thirdItem;
    }
}
