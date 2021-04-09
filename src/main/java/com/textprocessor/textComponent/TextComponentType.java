package com.textprocessor.textComponent;

public enum TextComponentType {
    MAIN(""),
    TEXT(""),
    LISTING("(?<code>\\{code}.+?\\{\\/code})"),
    PARAGRAPH(""),
    PARAGRAPH_DELIMITER("\n"),
    SENTENCE(""),
    SENTENCE_DELIMITER("[.!?]+\\s*"),
    WORD_WITH_PUNCTUATION(""),
    WORD_DELIMITER("\\s+"),
    WORD(""),
    PUNCTUATION("[,-:“;»«)(]"),
    SYMBOL("(.{1})");


    private final String regexp;

    TextComponentType(String regexp) {
        this.regexp = regexp;
    }

    public String getRegexp() {
        return regexp;
    }

}
