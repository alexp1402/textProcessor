package com.textprocessor.textComponent;

import java.util.Iterator;

public interface Component {

//    ComponentType type;
//    Component parent;
//    List<Component> components;
//
    void add(Component component);
    void remove(Component component);

    Component getParent();
    String getEntity();
    Iterator<Component> getIterator();
}
