package t01_Generics.p08_CustomListSorter;

public class CustomListSorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        list.sort();
    }
}
