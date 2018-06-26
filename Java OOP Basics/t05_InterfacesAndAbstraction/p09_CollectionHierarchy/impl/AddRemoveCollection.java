package t05_InterfacesAndAbstraction.p09_CollectionHierarchy.impl;

import t05_InterfacesAndAbstraction.p09_CollectionHierarchy.api.Removable;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection implements Removable {

    private List<String> list;

    public AddRemoveCollection() {
        this.list = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.list.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return this.list.remove(this.list.size() - 1);
    }
}
