package com.textprocessor.parser;

import com.textprocessor.textComponent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Logger LOG = LoggerFactory.getLogger(Parser.class);

    public void parseWithDelimiter(ITextComponent source, TextComponentType delimiter, TextComponentType result, boolean cleareEmpty) {
        LOG.info("Use ParseWithDelimeter method with sourceType {} and delimiterType {} We will get resultType {}", source.getType(), delimiter, result);
        if (source == null || delimiter == null || result == null) {
            LOG.error("You try to use parseWithDelimiter method with NULL parameter");
            throw new IllegalArgumentException("You try to use parseWithDelimiter method with NULL parameter");
        }
        int index = 0;
        String text = source.getEntity();
        Pattern pattern = Pattern.compile(delimiter.getRegexp(), Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);
        LOG.info("SOURCE->\n{}", source.getEntity());
        while (matcher.find()) {

            //if cleareEmpty flag ON(true) check IF index equal matcher.start - do nothing
            if (!cleareEmpty) {
                source.add(new TextComponent(result, text.substring(index, matcher.start()), source));
            } else {
                if (index != matcher.start()) {
                    source.add(new TextComponent(result, text.substring(index, matcher.start()), source));
                }
            }

            source.add(new TextComponent(delimiter, matcher.group(), source));
            index = matcher.end();
        }

        if (index != text.length()) {
            source.add(new TextComponent(result, text.substring(index), source));
        }
    }

    public void parse(ITextComponent source, TextComponentType component) {
        LOG.info("Use Parse method with sourceType {} and We will get resultType {}", source.getType(), component);
        if (source == null || component == null) {
            LOG.error("You try to use parse method with NULL parameter");
            throw new IllegalArgumentException("You try to use parse method with NULL parameter");
        }

        String text = source.getEntity();
        Pattern pattern = Pattern.compile(component.getRegexp());
        Matcher matcher = pattern.matcher(text);
        LOG.info("SOURCE->\n{}", source.getEntity());
        while (matcher.find()) {
            source.add(new TextComponent(component, matcher.group(), source));
        }
    }

}
