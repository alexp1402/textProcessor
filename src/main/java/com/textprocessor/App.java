package com.textprocessor;

import com.textprocessor.textComponent.TextComponent;
import com.textprocessor.textComponent.TextComponentType;
import com.textprocessor.textComponent.ITextComponent;
import com.textprocessor.parser.ParseBuilder;

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

        ITextComponent main = new TextComponent(TextComponentType.MAIN,text,null);
        ParseBuilder builder = new ParseBuilder(main);
        ITextComponent rez = builder.listing().paragraph().sentence().wordPunctuation().word().letter().build();


//        for(IComponent c : rez.getEach(ComponentType.LETTER)){
//            System.out.println(ComponentType.LETTER+" ---\n"+c.getEntity());
//        }
//
//        System.out.println("###############");
//        for(IComponent c : rez.getEach(ComponentType.PUNCTUATION)){
//            System.out.println(ComponentType.PUNCTUATION+" ---\n"+c.getEntity());
//        }

        System.out.println(main.collect());
    }
}
