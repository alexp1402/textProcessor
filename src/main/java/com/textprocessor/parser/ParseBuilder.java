package com.textprocessor.parser;

import com.textprocessor.textComponent.TextComponentType;
import com.textprocessor.textComponent.ITextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(ParseBuilder.class);

    private final ITextComponent component;
    private final Parser parser;

    public ParseBuilder(ITextComponent component) {
        this.component = component;
        parser = new Parser();
    }

    //for basic text Delimiter by TEXT and LISTING
    public ParseBuilder listing() {
        parser.parseWithDelimiter(component, TextComponentType.LISTING, TextComponentType.TEXT);
        return this;
    }

    //for TEXT only Delimiter by PARAGRAPH and "PARAGRAPH DELIMIT"
    public ParseBuilder paragraph() {
        for (ITextComponent comp : component.getEach(TextComponentType.TEXT)) {
            parser.parseWithDelimiter(comp, TextComponentType.PARAGRAPH_DELIMITER, TextComponentType.PARAGRAPH);
        }
        return this;
    }

    //for PARAGRAPH Delimiter by SENTENCE and "SENTENCE DELIMIT"
    public ParseBuilder sentence() {
        for (ITextComponent comp : component.getEach(TextComponentType.PARAGRAPH)) {
            parser.parseWithDelimiter(comp, TextComponentType.SENTENCE_DELIMITER, TextComponentType.SENTENCE);
        }
        return this;
    }

    //for SENTENCE Delimiter by WORD_WITH_PUNCTUATION and SPACE
    public ParseBuilder wordPunctuation() {
        for (ITextComponent comp : component.getEach(TextComponentType.SENTENCE)) {
            parser.parseWithDelimiter(comp, TextComponentType.SPACE, TextComponentType.WORD_WITH_PUNCTUATION);
        }
        return this;
    }

    //for WORD_WITH_PUNCTUATION Delimiter by WORD and PUNCTUATION
    public ParseBuilder word() {
        for (ITextComponent comp : component.getEach(TextComponentType.WORD_WITH_PUNCTUATION)) {
            parser.parseWithDelimiter(comp, TextComponentType.PUNCTUATION, TextComponentType.WORD);
        }
        return this;
    }

    //for WORD Delimiter by each LETTER
    public ParseBuilder letter() {
        for (ITextComponent comp : component.getEach(TextComponentType.WORD)) {
            parser.parse(comp, TextComponentType.LETTER);
        }
        return this;
    }

    public ITextComponent build() {
        return component;
    }

}
