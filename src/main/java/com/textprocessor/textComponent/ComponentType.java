package com.textprocessor.textComponent;

public enum ComponentType {
    MAIN(""),
    TEXT(""),
    LISTING("(?<code>\\{code}.+?\\{\\/code})"),
    PARAGRAPH(""),
    PARAGRAPH_DELIMITER("\n"),
    SENTENCE(""),
    SENTENCE_DELIMITER("[.!?]+\\s+"),
    WORD_WITH_PUNCTUATION(""),
    SPACE("\\s+"),
    WORD(""),
    PUNCTUATION("[,-:“;»«)(]"),
    LETTER("(.{1})");


    private final String regexp;

    ComponentType(String regexp){
        this.regexp = regexp;
    }

    public String getRegexp(){
        return regexp;
    }

}
