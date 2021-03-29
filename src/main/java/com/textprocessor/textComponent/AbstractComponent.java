package com.textprocessor.textComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractComponent implements Component{
    private ComponentType type;
    private List<Component> components;
    private Component parent;
    private String text;

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public String getEntity() {
        return text;
    }

    @Override
    public Iterator<Component> getIterator() {
        return components.iterator();
    }
}
