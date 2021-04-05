package com.textprocessor.parser;

import com.textprocessor.textComponent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Logger LOG = LoggerFactory.getLogger(Parser.class);

    public void parseWithDelimiter(ITextComponent source, TextComponentType delimiter, TextComponentType result) {
        int index = 0;
        String text = source.getEntity();
        Pattern pattern = Pattern.compile(delimiter.getRegexp(), Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            source.add(new TextComponent(result, text.substring(index, matcher.start()), source));
            source.add(new TextComponent(delimiter, matcher.group(), source));
            index = matcher.end();
        }

        if (index != text.length()) {
            source.add(new TextComponent(result, text.substring(index), source));
        }

    }

    public void parse(ITextComponent source, TextComponentType component) {
        String text = source.getEntity();
        Pattern pattern = Pattern.compile(component.getRegexp());
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            source.add(new TextComponent(component, matcher.group(), source));
        }

    }

}
