package com.textprocessor.parser;

import com.textprocessor.textComponent.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    public void parseWithDelimiter(IComponent source, ComponentType delimiter, ComponentType result) {
        int index = 0;
        String text = source.getEntity();
        Pattern pattern = Pattern.compile(delimiter.getRegexp(), Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            source.add(new Component(result, text.substring(index, matcher.start()), source));
            source.add(new Component(delimiter, matcher.group(), source));
            index = matcher.end();
        }

        if (index != text.length()) {
            source.add(new Component(result, text.substring(index), source));
        }

    }

    public void parse(IComponent source, ComponentType component) {
        String text = source.getEntity();
        Pattern pattern = Pattern.compile(component.getRegexp());
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            source.add(new Component(component, matcher.group(), source));
        }

    }

}
