package com.textprocessor;

import com.textprocessor.parser.TextParser;
import com.textprocessor.textComponent.Component;
import com.textprocessor.textComponent.ComponentType;
import com.textprocessor.textComponent.ParagraphComponent;
import com.textprocessor.textComponent.TextComponent;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String text ="Matcher и MatchResult\n" +
                "\n" +
                "Matcher — класс, который представляет строку, реализует механизм согласования (matching) с РВ. И хранит результаты этого согласования (используя реализацию методов интерфейса MatchResult). Не имеет публичных конструкторов, поэтому для создания объекта этого класса нужно использовать метод matcher класса Pattern:\n" +
                "\n" +
                "// будем искать URL\n" +
                "String regexp = \"^(https?:\\\\/\\\\/)?([\\\\da-z\\\\.-]+)\\\\.([a-z\\\\.]{2,6})([\\\\/\\\\w \\\\.-]*)*\\\\/?$\";\n" +
                "String url = \"http://habrahabr.ru/post/260767/\";\n" +
                "\n" +
                "Pattern pattern = Pattern.compile(regexp);\n" +
                "Matcher matcher = pattern.matcher(url);\n" +
                "\n" +
                "Но результатов у нас еще нет. Чтобы их получить нужно воспользоваться методом find. Можно использовать matches — этот метод вернет true только тогда, когда вся строка соответствует заданному РВ, в отличии от find, который пытается найти подстроку, которая удовлетворяет РВ. Для более детальной информации о результатах согласования можно использовать реализацию методов интерфейса MatchResult, например:";

        TextParser tp = new TextParser();
        Component txt = new TextComponent(text);
        tp.paragraphParse(txt);

        Iterator<Component> it = txt.getIterator();
        while(it.hasNext()){
            //System.out.println("#######################PARAGRAPH###################################");
            //System.out.println(it.next().getEntity());
            Component c = it.next();
            //Iterator<Component> sit = c.getIterator();
            tp.sentenceParse(c);
            Iterator<Component> sit = c.getIterator();
            while(sit.hasNext()){
                Component s = sit.next();
                tp.wordParse(s);
            }
        }
/*
        it = txt.getIterator();
        while(it.hasNext()){
            Component c = it.next();
            Iterator<Component> sit = c.getIterator();
            while(sit.hasNext()){
                Component s = sit.next();
                tp.wordParse(s);
            }
        }
        /*
        pattern = Pattern.compile("^(.+)$\\n",Pattern.MULTILINE);
        System.out.println("REGEXP->"+ ComponentType.PARAGRAPH.getRegexp());

        texts = text.split("\n");
        matcher = pattern.matcher(text);
        System.out.println(texts.length);
        for(String el:texts){
            System.out.println("###################################################################################");
            System.out.println(el);
        }

        matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(matcher.group(1));
        }

         */
    }
}
