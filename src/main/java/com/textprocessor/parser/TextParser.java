package com.textprocessor.parser;

import com.textprocessor.textComponent.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String[] codeParse(String text){
        String [] result = {""};
        Pattern pattern = Pattern.compile(ComponentType.LISTING.getRegexp());
        Matcher matcher = pattern.matcher(text);
        int i=0;
        while(matcher.find()){
            result[i++] = matcher.group(1);
        }
        return result;
    }

}
