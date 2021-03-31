package com.textprocessor.textComponent;

import com.textprocessor.parser.Parser;

import java.util.Iterator;

public class ParseBuilder {
    private IComponent component;
    private Parser parser;

    public ParseBuilder(IComponent component){
        this.component = component;
        parser = new Parser();
    }

    //for basic text Delimiter by TEXT and LISTING
    public ParseBuilder listing(){
        parser.parseWithDelimiter(component, ComponentType.LISTING,ComponentType.TEXT);
        return this;
    }

    //for TEXT only Delimiter by PARAGRAPH and "PARAGRAPH DELIMIT"
    public ParseBuilder paragraph(){
        for(IComponent comp:component.getEach(ComponentType.TEXT)) {
            parser.parseWithDelimiter(comp,ComponentType.PARAGRAPH_DELIMITER,ComponentType.PARAGRAPH);
        }
        return this;
    }

    //for PARAGRAPH Delimiter by SENTENCE and "SENTENCE DELIMIT"
    public ParseBuilder sentence(){
        for(IComponent comp:component.getEach(ComponentType.PARAGRAPH)){
            parser.parseWithDelimiter(comp,ComponentType.SENTENCE_DELIMITER,ComponentType.SENTENCE);
        }
        return this;
    }

    //for SENTENCE Delimiter by WORD_WITH_PUNCTUATION and SPACE
    public ParseBuilder wordPunctuation(){
        for(IComponent comp:component.getEach(ComponentType.SENTENCE)){
            parser.parseWithDelimiter(comp,ComponentType.SPACE,ComponentType.WORD_WITH_PUNCTUATION);
        }
        return this;
    }

    //for WORD_WITH_PUNCTUATION Delimiter by WORD and PUNCTUATION
    public ParseBuilder word(){
        for(IComponent comp:component.getEach(ComponentType.WORD_WITH_PUNCTUATION)){
            parser.parseWithDelimiter(comp,ComponentType.PUNCTUATION,ComponentType.WORD);
        }
        return this;
    }

    //for WORD Delimiter by each LETTER
    public ParseBuilder letter(){
        for(IComponent comp:component.getEach(ComponentType.WORD)){
            parser.parse(comp,ComponentType.LETTER);
        }
        return this;
    }

    public IComponent build(){
        return component;
    }

}
