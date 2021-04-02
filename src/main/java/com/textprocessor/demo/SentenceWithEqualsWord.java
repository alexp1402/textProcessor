package com.textprocessor.demo;

import com.textprocessor.parser.ParseBuilder;
import com.textprocessor.textComponent.Component;
import com.textprocessor.textComponent.ComponentType;
import com.textprocessor.textComponent.IComponent;

import java.util.*;

public class SentenceWithEqualsWord {
    public static void main(String[] args) {
        IComponent text = new Component(Text.text);
        ParseBuilder pb = new ParseBuilder(text);
        //List<IComponent> sentencesLink = new ArrayList<>();
        Map<IComponent,List<IComponent>> uniqueWords = new HashMap<>();

        pb.listing().paragraph().sentence().wordPunctuation().word().build();

        //System.out.println(text.collect());
        for(IComponent word: text.getEach(ComponentType.WORD)){

            if(uniqueWords.containsKey(word)){

                uniqueWords.get(word).add(word.getParent(ComponentType.SENTENCE));
                //System.out.println("ffff");
            }else{
                List<IComponent> sentencesLink = new ArrayList<>();
                sentencesLink.add(word.getParent(ComponentType.SENTENCE));
                uniqueWords.put(word,sentencesLink);
            }

            //System.out.println(word.getEntity()+" #SENTENCE#-> "+word.getParent(ComponentType.SENTENCE).getEntity());
            //System.out.println(word.getEntity()+" #HASH#-> "+word.hashCode());
        }


//        for(IComponent word:uniqueWords.keySet()){
//            if(uniqueWords.get(word).size()>1){
//                System.out.println("WORD-> "+word.getEntity()+" in Sentence "+uniqueWords.get(word).size());
//            }
//        }

        //RESULT
        Optional<List<IComponent>> maxList = uniqueWords.values().stream().max((val1,val2)->Integer.compare(val1.size(),val2.size()));
        

        if(maxList.isPresent()){
            Optional<IComponent> maxWord = uniqueWords.
            System.out.println("Sentences with MAX repeated words("+"");
            for(IComponent comp:maxList.get()){
                System.out.println(comp.getEntity());
            }
        }else{
            /////////////////////////////////////////
            //////////////////////////////////////////
            /////////////////////////////////////////
            throw new IllegalArgumentException();
        }




    }
}
