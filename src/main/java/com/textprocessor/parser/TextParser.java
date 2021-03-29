package com.textprocessor.parser;

import com.textprocessor.textComponent.*;

public class TextParser {

    public void paragraphParse(Component component){
        String text = component.getEntity();
        for(String p: text.split(ComponentType.PARAGRAPH.getRegexp())){
            component.add(new ParagraphComponent(component, p));
        }
    }

    public void sentenceParse(Component component){
        String text = component.getEntity();
        for(String p: text.split(ComponentType.SENTENCE.getRegexp())){
            component.add(new SentenceComponent(component, p));
        }

    }

    public void wordParse(Component component){
        String text = component.getEntity();
        for(String p: text.split(ComponentType.WORD.getRegexp())){
            component.add(new WordComponent(component, p));
            System.out.println("WWWW->"+p);
        }
    }

}
