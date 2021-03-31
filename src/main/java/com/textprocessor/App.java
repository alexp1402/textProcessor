package com.textprocessor;

import com.textprocessor.parser.Parser;
import com.textprocessor.textComponent.Component;
import com.textprocessor.textComponent.ComponentType;
import com.textprocessor.textComponent.IComponent;
import com.textprocessor.textComponent.ParseBuilder;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        String text = "Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
                "\n" +
                "Пример создания матчера:\n" +
                "{code}\n" +
                "Pattern p = Pattern.compile(\"a*b\");// скомпилировали регулярное выражение в представление\n" +
                "Matcher m = p.matcher(\"aaaaab\");//создали поисковик в тексте “aaaaab” по шаблону \"a*b\"\n" +
                "\n {/code}" +
                "Теперь с помощью нашего? «поисковика» {code} мы можем искать совпадения {/code}, узнавать позицию совпадения в тексте, заменять текст с помощью методов класса.\n" +
                "\n" +
                "Метод boolean find() ищет очередное совпадение в тексте с шаблоном. С помощью этого метода и оператора цикла можно производить анализ всего текста по событийной модели (осуществлять необходимые операции при наступлении события";

        IComponent main = new Component(ComponentType.MAIN,text,null);
        ParseBuilder builder = new ParseBuilder(main);
        IComponent rez = builder.listing().paragraph().sentence().wordPunctuation().word().letter().build();


        for(IComponent c : rez.getEach(ComponentType.LETTER)){
            System.out.println(ComponentType.LETTER+" ---\n"+c.getEntity());
        }
//        System.out.println("###############");
//        for(IComponent c : rez.getEach(ComponentType.PUNCTUATION)){
//            System.out.println(ComponentType.PUNCTUATION+" ---\n"+c.getEntity());
//        }

    }
}
