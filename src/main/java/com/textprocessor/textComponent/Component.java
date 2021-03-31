package com.textprocessor.textComponent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Component implements IComponent{

    private ComponentType type;
    private List<IComponent> childs=new LinkedList<>();
    private IComponent parent=null;
    private String text;

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
    public IComponent getParent() {
        return parent;
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

        for(IComponent component:childs){
            if(component.getType().equals(type)){
                componentsList.add(component);
            }else{
                List<IComponent> childList = component.getEach(type);
                if(!childList.isEmpty()){
                    componentsList.addAll(childList);
                }
            }
        }
        return componentsList;
    }
//
//    @Override
//    public String collect(IComponent ...comp) {
//        StringBuilder text = new StringBuilder();
//        text.append(this.getType()+" ___ WITH COMPONENT====>\n");
//        for(IComponent c:childs){
//            if()
//            text.append(c.collect(c));
//        }
//        return text.toString();
//    }

//    @Override
//    public boolean isComponentOf(ComponentType[] type) {
//        boolean flag=true;
//        if(type.length!=0){
//
//        }
//
//        return true;
//    }

}
