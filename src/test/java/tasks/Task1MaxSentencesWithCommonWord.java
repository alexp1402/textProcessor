package tasks;

import com.textprocessor.demo.Text;
import com.textprocessor.parser.ParseBuilder;
import com.textprocessor.textComponent.ITextComponent;
import com.textprocessor.textComponent.TextComponent;
import com.textprocessor.textComponent.TextComponentType;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.PreTextTestSetup;

import java.util.*;
import java.util.stream.Collectors;

public class Task1MaxSentencesWithCommonWord {

    @Test
    public void maxSentencesWithCommonWords(){
        ITextComponent text = new TextComponent(PreTextTestSetup.textFull);
        ParseBuilder parseBuilder = new ParseBuilder(text);
        Map<ITextComponent, List<ITextComponent>> uniqueWords = new HashMap<>();

        parseBuilder.listing().paragraph().sentence().word().build();

        for(ITextComponent word: text.getEach(TextComponentType.WORD)){
            if(uniqueWords.containsKey(word)){
                uniqueWords.get(word).add(word.getParent(TextComponentType.SENTENCE));
            }else{
                List<ITextComponent> sentencesLink = new ArrayList<>();
                sentencesLink.add(word.getParent(TextComponentType.SENTENCE));
                uniqueWords.put(word,sentencesLink);
            }
        }

        Optional<ITextComponent> maxList = uniqueWords
                .entrySet()
                .stream()
                .max((val1,val2)->Integer.compare(val1.getValue().size(),val2.getValue().size()))
                .map(Map.Entry::getKey);

        if(maxList.isPresent()){
            ITextComponent max =  maxList.get();
            System.out.println("Sentences with MAX repeated words {"+max.getEntity()+"} in "+uniqueWords.get(max).size()+" sentences:");
            uniqueWords.get(max).stream().forEach((e)-> System.out.println(e.getEntity()));
        }else{
            System.out.println("Something wrong (may be no sentences) Try again");
        }


    }
}
