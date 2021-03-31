package com.textprocessor.textComponent;

import java.util.Iterator;
import java.util.List;

public interface IComponent {

//    ComponentType type;
//    Component parent;
//    List<Component> components;
//
    void add(IComponent IComponent);
    void remove(IComponent IComponent);

    IComponent getParent();
    String getEntity();
    Iterator<IComponent> getIterator();
    ComponentType getType();
    List<IComponent> getEach(ComponentType type);

//    String collect(ComponentType ...type);
//    boolean isComponentOf(ComponentType[] type);
}

