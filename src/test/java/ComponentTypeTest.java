import com.textprocessor.textComponent.TextComponentType;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComponentTypeTest {
    String text = "Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
            "\n" +
            "Пример создания матчера:\n" +
            "{code}\n" +
            "Pattern p = Pattern.compile(\"a*b\");// скомпилировали регулярное выражение в представление\n" +
            "Matcher m = p.matcher(\"aaaaab\");//создали поисковик в тексте “aaaaab” по шаблону \"a*b\"\n" +
            "\n {/code}" +
            "Теперь с помощью нашего «поисковика» {code} мы можем искать совпадения {/code}, узнавать позицию совпадения в тексте, заменять текст с помощью методов класса.\n" +
            "\n" +
            "Метод boolean find() ищет очередное совпадение в тексте с шаблоном. С помощью этого метода и оператора цикла можно производить анализ всего текста по событийной модели (осуществлять необходимые операции при наступлении события";

    @Test
    void regexpParagraphParseTest(){
        Pattern p = Pattern.compile(TextComponentType.LISTING.getRegexp(),Pattern.DOTALL);


        Matcher m = p.matcher(text);
        int begin = 0;
        int end = 0;

        while(m.find()){
            String text2 = text.substring(begin,m.start());
            System.out.println("Text====\n"+text2);
            System.out.println("GROUP---- \n"+m.group());
            begin = m.end();

        }
        if(end!=text.length()){
            System.out.println("Text====\n"+text.substring(begin));
        }
    }
}
