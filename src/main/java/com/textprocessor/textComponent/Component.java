package com.textprocessor.textComponent;

import javax.swing.text.html.parser.Entity;
import java.util.*;


public class Component implements IComponent {

    private ComponentType type;
    private List<IComponent> childs = new ArrayList<>();
    private IComponent parent = null;
    private String text;

    //main with input text (first step)
    public Component(String text){
        this.type = ComponentType.MAIN;
        this.text = text;
        this.parent = null;
    }

    //components during parsing
    public Component(ComponentType type, String text, IComponent parent) {
        this.type = type;
        this.text = text;
        this.parent = parent;
    }

    @Override
    public void add(IComponent component) {
        childs.add(component);
    }

    @Override
    public void remove(IComponent component) {
        childs.remove(component);
    }

    @Override
    public IComponent getParent(ComponentType type) {
        if(parent == null){
//////////////////////////////////////////////
//////////////////////////////////////////////
//////////////////////////////////////////////
            throw new IllegalArgumentException();
        }
        if(parent.getType().equals(type)){
            return parent;
        }else{
            return parent.getParent(type);
        }
    }

    @Override
    public String getEntity() {
        return text;
    }

    @Override
    public Iterator<IComponent> getIterator() {
        return childs.iterator();
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public List<IComponent> getEach(ComponentType type) {
        List<IComponent> componentsList = new LinkedList<>();

        for (IComponent component : childs) {
            if (component.getType().equals(type)) {
                componentsList.add(component);
            } else {
                List<IComponent> childList = component.getEach(type);
                if (!childList.isEmpty()) {
                    componentsList.addAll(childList);
                }
            }
        }

        return componentsList;
    }

    @Override
    public String collect() {
        StringBuilder text = new StringBuilder("");

        if (childs.size() == 0) {
            text.append(this.getEntity());
            return text.toString();
        }

        for (IComponent component : childs) {
            text.append(component.collect());
        }

        return text.toString();
    }

    @Override
    public int hashCode() {
        return (text.toLowerCase()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return text.toLowerCase().equals(((IComponent)obj).getEntity().toLowerCase());
    }
}
