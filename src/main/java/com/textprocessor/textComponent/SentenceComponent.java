package com.textprocessor.textComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SentenceComponent implements Component{
    private ComponentType type;
    private List<Component> words;
    private Component parent;
    private String sentenceText;

    public SentenceComponent(Component parent, String text){
        type = ComponentType.SENTENCE;
        this.parent = parent;
        sentenceText = text;
        words = new ArrayList<>();

    }

    @Override
    public void add(Component component) {
        words.add(component);
    }

    @Override
    public void remove(Component component) {
        words.remove(component);
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public String getEntity() {
        return sentenceText;
    }

    @Override
    public Iterator<Component> getIterator() {
        return words.iterator();
    }
}
