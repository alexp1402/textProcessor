package com.textprocessor.textComponent;

import com.textprocessor.textComponent.Component;
import com.textprocessor.textComponent.ComponentType;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TextComponent implements Component {
    private ComponentType type;
    private List<Component> paragraphs;
    private String text;

    public TextComponent(String text){
        this.text = text;
        type = ComponentType.TEXT;
        paragraphs = new LinkedList<>();
    }

    @Override
    public void add(Component component) {
        paragraphs.add(component);
    }

    @Override
    public void remove(Component component) {
        paragraphs.remove(component);
    }

    @Override
    public Component getParent() {
        return this;
    }

    @Override
    public Iterator<Component> getIterator() {
        return paragraphs.iterator();
    }

    @Override
    public String getEntity() {
        return text;
    }
}
