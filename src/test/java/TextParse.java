import com.textprocessor.parser.TextParser;
import com.textprocessor.textComponent.ComponentType;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParse {
    String text = "Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
            "\n" +
            "Пример создания матчера:\n" +
            "{code}\n" +
            "Pattern p = Pattern.compile(\"a*b\");// скомпилировали регулярное выражение в представление\n" +
            "Matcher m = p.matcher(\"aaaaab\");//создали поисковик в тексте “aaaaab” по шаблону \"a*b\"\n" +
            "\n {code}" +
            "Теперь с помощью нашего «поисковика» {code} мы можем искать совпадения {code}, узнавать позицию совпадения в тексте, заменять текст с помощью методов класса.\n" +
            "\n" +
            "Метод boolean find() ищет очередное совпадение в тексте с шаблоном. С помощью этого метода и оператора цикла можно производить анализ всего текста по событийной модели (осуществлять необходимые операции при наступлении события";

    @Test
    void parseCodeTest(){
        //TextParser tp = new TextParser();
        //String str[] = tp.codeParse(text);

        //code parse
        Pattern p = Pattern.compile(ComponentType.LISTING.getRegexp(),Pattern.DOTALL);
        Matcher m = p.matcher(text);
        System.out.println("Text length -"+text.length());

        while(m.find()){
            //System.out.println(m.group("code"));
            //System.out.println("from-"+m.start("code")+" ###---### to-"+m.end("code"));
        }
    }



}
