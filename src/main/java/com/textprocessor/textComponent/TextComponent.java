package com.textprocessor.textComponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class TextComponent implements ITextComponent{


    private static final Logger LOG = LoggerFactory.getLogger(ITextComponent.class);

    private final TextComponentType type;
    private final List<ITextComponent> childes = new ArrayList<>();
    private final ITextComponent parent;
    private final String text;

    //main with input text (first step)
    public TextComponent(String text){
        this.type = TextComponentType.MAIN;
        this.text = text;
        this.parent = null;
        LOG.info("Creating new MAIN TextComponent \n\n{} ",text);
    }

    //components during parsing
    public TextComponent(TextComponentType type, String text, ITextComponent parent) {
        if (type==null||text==null||parent==null){
            LOG.error("You try to create new TextComponent with NULL parameter Use TextComponent class directly");
            throw new IllegalArgumentException("You try to create new TextComponent with NULL parameter Use TextComponent class directly");
        }
        this.type = type;
        this.text = text;
        this.parent = parent;
        //Ask Max for BestPractice for such

        LOG.info("Creating new TextComponent \n TYPE={} \n ENTITY={} \n PARENT_TYPE={}", type, text, parent.getType());
    }

    @Override
    public void add(ITextComponent component) {
        childes.add(component);
        LOG.info("Adding to {} new child component TYPE={} \n ENTITY={}",this.type,component.getType(),component.getEntity());
    }

    @Override
    public boolean remove(ITextComponent component) {
        LOG.info("Remove from {} child component TYPE={} ENTITY={}",this.type,component.getType(),component.getEntity());
        return childes.remove(component);
    }

    @Override
    public ITextComponent getParent(TextComponentType type) {
        if(parent == null){
            LOG.error("Wrong logical level of TextComponents. You try find paren={} from={}. There is no one such parent",type, this.getType());
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
    public Iterator<ITextComponent> getIterator() {
        return childes.iterator();
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    //Return List of searching component type
    //Searching start from current ComponentText, till ChildComponent and Component whose childList is empty (like LeafTree Component)
    @Override
    public List<ITextComponent> getEach(TextComponentType type) {
        List<ITextComponent> componentsList = new LinkedList<>();

        for (ITextComponent component : childes) {
            if (component.getType().equals(type)) {
                componentsList.add(component);
            } else {
                //recursive call down for childComponent
                List<ITextComponent> childList = component.getEach(type);
                //if TextComponet is TreeLeaf do nothing Else
                if (!childList.isEmpty()) {
                    componentsList.addAll(childList);
                }
            }
        }
        return componentsList;
    }

    //Collect all component From current down to component with empty childList
    @Override
    public String collect() {
        StringBuilder text = new StringBuilder();
        //if LeafComponent
        if (childes.isEmpty()) {
            text.append(this.getEntity());
            return text.toString();
        }
        //Recursive appends all childes component
        for (ITextComponent component : childes) {
            text.append(component.collect());
        }
        return text.toString();
    }

    @Override
    public int hashCode() {
        //String hash code (need for exercise)
        return (text.toLowerCase()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //Compare ONLY entity (need for exercises HashMap)
        //NO type, NO parent field comparing
        return text.equalsIgnoreCase(((ITextComponent)obj).getEntity().toLowerCase());
    }

}
