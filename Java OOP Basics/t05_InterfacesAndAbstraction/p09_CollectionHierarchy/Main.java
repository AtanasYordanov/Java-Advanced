package t05_InterfacesAndAbstraction.p09_CollectionHierarchy;

import t05_InterfacesAndAbstraction.p09_CollectionHierarchy.api.Addable;
import t05_InterfacesAndAbstraction.p09_CollectionHierarchy.api.Removable;
import t05_InterfacesAndAbstraction.p09_CollectionHierarchy.impl.AddCollection;
import t05_InterfacesAndAbstraction.p09_CollectionHierarchy.impl.AddRemoveCollection;
import t05_InterfacesAndAbstraction.p09_CollectionHierarchy.impl.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Addable addCol = new AddCollection();
        Removable addRemoveCol = new AddRemoveCollection();
        Removable myList = new MyList();
        String[] elements = reader.readLine().split("\\s+");
        int removeCount = Integer.parseInt(reader.readLine());
        addElements(addCol, elements);
        addElements(addRemoveCol, elements);
        addElements(myList, elements);
        removeElements(addRemoveCol, removeCount);
        removeElements(myList, removeCount);
    }

    private static void addElements(Addable collection, String[] elements) {
        for (String element : elements) {
            System.out.print(collection.add(element) + " ");
        }
        System.out.println();
    }

    private static void removeElements(Removable collection, int count) {
        while (count-- > 0) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
