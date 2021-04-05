package textComponent;

import com.textprocessor.textComponent.ITextComponent;
import com.textprocessor.textComponent.TextComponent;
import com.textprocessor.textComponent.TextComponentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TextComponentTest {
    static ITextComponent text=new TextComponent("");


    @Test
    void addComponentTest(){
        ITextComponent textComp = new TextComponent("");

        for(TextComponentType type:TextComponentType.values()){
            TextComponent tc = new TextComponent(type,type.toString(),text);
            Assertions.assertDoesNotThrow(()->textComp.add(tc));
        }

        Iterator<ITextComponent> it = textComp.getIterator();
        while(it.hasNext()){
            ITextComponent comp = it.next();
            Assertions.assertEquals(comp.getType().toString(), comp.getEntity());
        }
    }

    @Test
    void removeComponentTest(){
        ITextComponent textComp = new TextComponent("");
        List<ITextComponent> listToDell = new ArrayList<>();

        //add then remove
        for(TextComponentType type:TextComponentType.values()){
            ITextComponent comp = new TextComponent(type,type.toString(),text);
            textComp.add(comp);
            listToDell.add(comp);
        }

        for(ITextComponent comp:listToDell){
            Assertions.assertTrue(textComp.remove(comp));
        }
        Assertions.assertFalse(textComp.getIterator().hasNext());
    }

    @Test
    void getParentTest_Right(){
        ITextComponent textComp = new TextComponent("");

        //add with previous like parent
        ITextComponent prev = text;
        for(TextComponentType type:TextComponentType.values()){
            TextComponent tc = new TextComponent(type,type.toString(),prev);
            text.add(tc);
            prev = tc;
        }
        //each component has paren.Type like prev.Type
        Iterator<ITextComponent> it = textComp.getIterator();
        prev = text;
        while(it.hasNext()){
            ITextComponent comp = it.next();
            Assertions.assertEquals(prev.getType(),comp.getParent(prev.getType()).getType());
        }
    }

    @Test
    void getParentTest_Wrong_IllegalArgumentException(){
        // logical error occurred when illegal logical level component
        // seem like "we search parent (WORD) in component (PARAGRAPH)"
        // right logical level TEXT->...PARAGRAPH->...SENTENCE->...WORD...
        ITextComponent paragraph = new TextComponent(TextComponentType.PARAGRAPH,"",text);
        Assertions.assertThrows(IllegalArgumentException.class, ()->paragraph.getParent(TextComponentType.WORD));
    }

    @Test
    void getEntityTest(){
        ITextComponent textComp = new TextComponent("");

        for(TextComponentType type:TextComponentType.values()){
            textComp.add(new TextComponent(type,type.toString(),text));
        }

        Iterator<ITextComponent> it = textComp.getIterator();
        while(it.hasNext()){
            ITextComponent comp = it.next();
            Assertions.assertEquals(comp.getType().toString(), comp.getEntity());
        }
    }

    @Test
    void getIteratorTest(){
        int childrenCount =5;
        for(int i=0;i<childrenCount;i++){
            text.add(new TextComponent(""));
        }
        Assertions.assertNotNull(text.getIterator());
        int currentChildes = 0;
        Iterator<ITextComponent> it = text.getIterator();
        while(it.hasNext()){
            currentChildes++;
            it.next();
        }
        Assertions.assertEquals(childrenCount,currentChildes);
    }

    @Test
    void getTypeTest(){
        for (TextComponentType type:TextComponentType.values()) {
            ITextComponent component = new TextComponent(type,"",text);
            Assertions.assertEquals(type,component.getType());
        }
    }

    @Test
    void getEachTest(){
        //Paragraph with (10) Sentence AND (10) Words & (10) Punctuation in each
        TextComponent paragraph = new TextComponent(TextComponentType.PARAGRAPH,"",text);
        for(int i=0;i<10;i++){
            ITextComponent sentence= new TextComponent(TextComponentType.SENTENCE,"",text);
            paragraph.add(sentence);
            for(int j=0;j<10;j++){
                sentence.add(new TextComponent(TextComponentType.WORD,"word",sentence));
                sentence.add(new TextComponent(TextComponentType.PUNCTUATION,"punctuation",sentence));
            }
        }

        int wordCount=0;
        int punctuationCount=0;
        for(ITextComponent sc:paragraph.getEach(TextComponentType.WORD)){
            Assertions.assertEquals("word",sc.getEntity());
            wordCount++;
        }
        for(ITextComponent sc:paragraph.getEach(TextComponentType.PUNCTUATION)){
            Assertions.assertEquals("punctuation",sc.getEntity());
            punctuationCount++;
        }

        Assertions.assertEquals(10*10, wordCount);
        Assertions.assertEquals(10*10,punctuationCount);
    }

    @Test
    void collectTest(){
        //generate sequence [0,100) 0;1;2;3;4;....99; and put into TextComponent with 10 Sentence then Collect and equal it
        StringBuilder expected = new StringBuilder();
        for (int i =0;i<100;i++)
            expected.append(i+";");

        //TextComponent
        TextComponent paragraph = new TextComponent(TextComponentType.PARAGRAPH,"",text);
        for(int i=0;i<10;i++){
            ITextComponent sentence= new TextComponent(TextComponentType.SENTENCE,"",text);
            paragraph.add(sentence);
            for(int j=0;j<10;j++){
                sentence.add(new TextComponent(TextComponentType.WORD,Integer.toString(i*10+j)+";",sentence));
            }
        }

        Assertions.assertEquals(expected.toString(),paragraph.collect());
    }


}
