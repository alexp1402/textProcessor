package com.textprocessor.textComponent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParagraphComponent implements Component {
    private ComponentType type;
    private List<Component> sentences;
    private Component parent;
    private String paragraphText;

    public ParagraphComponent(Component parent, String text) {
        type = ComponentType.PARAGRAPH;
        this.parent = parent;
        sentences = new LinkedList<>();
        paragraphText = text;
    }

    @Override
    public void add(Component component) {
        sentences.add(component);
    }

    @Override
    public void remove(Component component) {
        sentences.remove(component);
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public Iterator<Component> getIterator() {
        return sentences.iterator();
    }

    @Override
    public String getEntity() {
        return paragraphText;
    }
}
