package parser;

import com.textprocessor.parser.Parser;
import com.textprocessor.textComponent.TextComponent;
import com.textprocessor.textComponent.TextComponentType;
import com.textprocessor.textComponent.ITextComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class ParserTest {

    @Test
    public void parseWordTest(){
        String word = "world";
        ITextComponent comp = new TextComponent(TextComponentType.WORD,word,null);
        Parser parser = new Parser();
        parser.parse(comp, TextComponentType.LETTER);
        Iterator<ITextComponent> it= comp.getIterator();
        int count = 0;
        while(it.hasNext()){
            System.out.println("LETTER->"+it.next().getEntity());
            count++;
        }
        Assertions.assertEquals(count,word.length());
    }
}
