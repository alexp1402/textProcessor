package parser;

import com.textprocessor.parser.Parser;
import com.textprocessor.textComponent.Component;
import com.textprocessor.textComponent.ComponentType;
import com.textprocessor.textComponent.IComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class ParserTest {

    @Test
    public void parseWordTest(){
        String word = "world";
        IComponent comp = new Component(ComponentType.WORD,word,null);
        Parser parser = new Parser();
        parser.parse(comp,ComponentType.LETTER);
        Iterator<IComponent> it= comp.getIterator();
        int count = 0;
        while(it.hasNext()){
            System.out.println("LETTER->"+it.next().getEntity());
            count++;
        }
        Assertions.assertEquals(count,word.length());
    }
}
