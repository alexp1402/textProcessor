package com.textprocessor.demo;

import com.textprocessor.parser.ParseBuilder;
import com.textprocessor.textComponent.TextComponent;
import com.textprocessor.textComponent.TextComponentType;
import com.textprocessor.textComponent.ITextComponent;

import java.util.*;

public class SentenceWithEqualsWord {



    public static void main(String[] args) {
        ITextComponent text = new TextComponent(Text.text);
        ParseBuilder pb = new ParseBuilder(text);
        Map<ITextComponent,List<ITextComponent>> uniqueWords = new HashMap<>();

        pb.listing().paragraph().sentence().wordPunctuation().word().build();

        //System.out.println(text.collect());
        for(ITextComponent word: text.getEach(TextComponentType.WORD)){
            if(uniqueWords.containsKey(word)){
                uniqueWords.get(word).add(word.getParent(TextComponentType.SENTENCE));
            }else{
                List<ITextComponent> sentencesLink = new ArrayList<>();
                sentencesLink.add(word.getParent(TextComponentType.SENTENCE));
                uniqueWords.put(word,sentencesLink);
            }

            //System.out.println(word.getEntity()+" #SENTENCE#-> "+word.getParent(ComponentType.SENTENCE).getEntity());
            //System.out.println(word.getEntity()+" #HASH#-> "+word.hashCode());
        }


//        for(IComponent word:uniqueWords.keySet()){
//            if(uniqueWords.get(word).size()>1){
//                System.out.println("WORD->"+word.getEntity()+" in Sentence "+uniqueWords.get(word).size()+" TYPE->"+word.getType());
//            }
//        }

        //RESULT
        Optional<ITextComponent> maxList = uniqueWords
                .entrySet()
                .stream()
                .max((val1,val2)->Integer.compare(val1.getValue().size(),val2.getValue().size()))
                .map(Map.Entry::getKey)
                .stream()
                .findFirst();


        if(maxList.isPresent()){
            //Optional<IComponent> maxWord = uniqueWords.
            System.out.println("Sentences with MAX repeated words("+"");
//            for(IComponent comp:maxList.get()){
//                System.out.println(comp.getEntity());
//            }
//            System.out.println("WORD-"+maxList.get().getEntity()+" in: ");
//            for(IComponent c:uniqueWords.get(maxList.get().getEntity())){
//                System.out.println(c.getEntity());
//            }
        }else{
            /////////////////////////////////////////
            //////////////////////////////////////////
            /////////////////////////////////////////
            throw new IllegalArgumentException();
        }




    }
}
