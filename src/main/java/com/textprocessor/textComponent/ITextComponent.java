package com.textprocessor.textComponent;

import java.util.Iterator;
import java.util.List;

public interface ITextComponent {

    void add(ITextComponent ITextComponent);

    boolean remove(ITextComponent ITextComponent);

    ITextComponent getParent(TextComponentType type);

    String getEntity();

    Iterator<ITextComponent> getIterator();

    TextComponentType getType();

    List<ITextComponent> getEach(TextComponentType type);

    String collect();
}

