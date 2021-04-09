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
        if (component == null) {
            LOG.error("You try to use ParseBuilder with NULL text component");
            throw new IllegalArgumentException("You try to use ParseBuilder with NULL text component");
        }
        this.component = component;
        parser = new Parser();
        LOG.info("Creating ParseBuilder with Parser and TextComponent type {}", component.getType());
    }

    //for basic text Delimiter by TEXT and LISTING
    public ParseBuilder listing() {
        parser.parseWithDelimiter(component, TextComponentType.LISTING, TextComponentType.TEXT, false);
        return this;
    }

    //for TEXT only Delimiter by PARAGRAPH and "PARAGRAPH DELIMIT"
    public ParseBuilder paragraph() {
        for (ITextComponent comp : component.getEach(TextComponentType.TEXT)) {
            parser.parseWithDelimiter(comp, TextComponentType.PARAGRAPH_DELIMITER, TextComponentType.PARAGRAPH, false);
        }
        return this;
    }

    //for PARAGRAPH Delimiter by SENTENCE and "SENTENCE DELIMIT"
    public ParseBuilder sentence() {
        for (ITextComponent comp : component.getEach(TextComponentType.PARAGRAPH)) {
            parser.parseWithDelimiter(comp, TextComponentType.SENTENCE_DELIMITER, TextComponentType.SENTENCE, false);
        }
        return this;
    }

    //PRIVATE for SENTENCE Delimiter by WORD_WITH_PUNCTUATION and SPACE
    private ParseBuilder wordPunctuation() {
        for (ITextComponent comp : component.getEach(TextComponentType.SENTENCE)) {
            parser.parseWithDelimiter(comp, TextComponentType.WORD_DELIMITER, TextComponentType.WORD_WITH_PUNCTUATION, false);
        }
        return this;
    }

    //for WORD_WITH_PUNCTUATION Delimiter by WORD and PUNCTUATION
    public ParseBuilder word() {
        wordPunctuation();
        for (ITextComponent comp : component.getEach(TextComponentType.WORD_WITH_PUNCTUATION)) {
            parser.parseWithDelimiter(comp, TextComponentType.PUNCTUATION, TextComponentType.WORD, true);
        }
        return this;
    }

    //for WORD Delimiter by each LETTER
    public ParseBuilder letter() {
        for (ITextComponent comp : component.getEach(TextComponentType.WORD)) {
            parser.parse(comp, TextComponentType.SYMBOL);
        }
        return this;
    }

    public ITextComponent build() {
        return component;
    }

}
