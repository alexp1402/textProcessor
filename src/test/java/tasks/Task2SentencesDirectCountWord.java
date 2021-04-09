package tasks;

import com.textprocessor.parser.ParseBuilder;
import com.textprocessor.textComponent.ITextComponent;
import com.textprocessor.textComponent.TextComponent;
import com.textprocessor.textComponent.TextComponentType;
import org.junit.jupiter.api.Test;
import parser.PreTextTestSetup;

import java.util.*;

public class Task2SentencesDirectCountWord {
    @Test
    public void sentencesDirectWordCountIn(){
        ITextComponent text = new TextComponent(PreTextTestSetup.textFull);
        ParseBuilder parseBuilder = new ParseBuilder(text);
        Map<Integer,ITextComponent> sentencesWord = new TreeMap<>();

        parseBuilder.listing().paragraph().sentence().word().build();

        for(ITextComponent sentence: text.getEach(TextComponentType.SENTENCE)){
            Integer wordCount = sentence.getEach(TextComponentType.WORD).size();
            //System.out.println("");
            sentencesWord.put(wordCount, sentence);
        }

        sentencesWord.entrySet().stream()
                .forEach((e)->{System.out.println("WordCount="+e.getKey()+" in Sentence->"+ e.getValue().getEntity());
        });

    }
}
