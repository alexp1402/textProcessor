package com.textprocessor.textComponent;

public enum ComponentType {
    TEXT(""),
    LISTING("(?<code>\\{code}.+?\\{code})"),
    PARAGRAPH("(.*?)$\\n"),
    SENTENCE("[.!?]+"),
    WORD("\\s"),
    SYMBOL(""),
    PUNCTUATION("");

    private final String regexp;

    ComponentType(String regexp){
        this.regexp = regexp;
    }

    public String getRegexp(){
        return regexp;
    }

}
