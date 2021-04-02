package com.textprocessor.textComponent;

import java.util.Iterator;
import java.util.List;

public interface IComponent {

    void add(IComponent IComponent);

    void remove(IComponent IComponent);

    IComponent getParent(ComponentType type);

    String getEntity();

    Iterator<IComponent> getIterator();

    ComponentType getType();

    List<IComponent> getEach(ComponentType type);

    String collect();
}

