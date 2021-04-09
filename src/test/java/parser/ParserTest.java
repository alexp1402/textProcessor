package parser;

import com.textprocessor.parser.Parser;
import com.textprocessor.textComponent.TextComponent;
import com.textprocessor.textComponent.TextComponentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParserTest {

    static Parser parser = new Parser();

    static Stream<Arguments> argumentsForListing() {
        return Stream.of(
                Arguments.of("Full text test", PreTextTestSetup.textFull, 1),
                Arguments.of("Text without listing({code})", PreTextTestSetup.textWithoutCode, 0),
                Arguments.of("Text with 2 part of Listing", PreTextTestSetup.textWith2Code, 2),
                Arguments.of("Text with wrong Listing (only open {code})", PreTextTestSetup.textWithWrongCode, 0)
        );
    }

    static Stream<Arguments> argumentsForParagraph() {
        return Stream.of(
                Arguments.of("Text with one (fill) paragraphs",PreTextTestSetup.textOneParagraph,1,0),
                Arguments.of("Text with three (fill) paragraphs",PreTextTestSetup.textThreeParagraph,3,2),
                Arguments.of("Text with five (3 fill and 2 empty) paragraphs",PreTextTestSetup.textFiveParagraph,5,4)
        );
    }

    static Stream<Arguments> argumentsForSentence(){
        return Stream.of(
                Arguments.of("Text with one sentence (. dot ended)",PreTextTestSetup.textOneSentence,1,1),
                Arguments.of("Text with one sentence (without . dot ended)",PreTextTestSetup.textOneSentenceWithout,1,0),
                Arguments.of("Text with three Sentences (. ! ?)",PreTextTestSetup.textThreeSentences,3,3),
                Arguments.of("Text with three Sentences (. !! ???) paragraphs",PreTextTestSetup.textThreeSentencesMultiDOT,3,3)
        );
    }

    static Stream<Arguments> argumentsForWordWithPunctuation(){
        return Stream.of(
                Arguments.of("Five word with punctuation",PreTextTestSetup.textFiveWordPunctuation,5,4),
                Arguments.of("Five word",PreTextTestSetup.textFiveWord,5,4),
                Arguments.of("Four word (word with -)",PreTextTestSetup.textFourWordWith,4,3)
        );
    }

    static Stream<Arguments> argumentsForPunctuation(){
        return Stream.of(
                Arguments.of("Word with « »",PreTextTestSetup.textWordWithQuotes,1,2),
                Arguments.of("Word with “ “",PreTextTestSetup.textWordWithQuotes2,1,2),
                Arguments.of("Word with ( )",PreTextTestSetup.textWordWithBrackets,1,2),
                Arguments.of("Word with ;",PreTextTestSetup.textWordWithSemicolon,1,1),
                Arguments.of("Word with :",PreTextTestSetup.textWordWithColon,1,1),
                Arguments.of("Word with -",PreTextTestSetup.textWordWithDash,1,1),
                Arguments.of("Clean word without punctuation",PreTextTestSetup.textWordClean,1,0)
        );
    }

    static Stream<Arguments> argumentsForLetter(){
        return Stream.of(
                Arguments.of("5 symbols word",PreTextTestSetup.textWord5Letters,5),
                Arguments.of("1 symbols word",PreTextTestSetup.textWord1Letters,1),
                Arguments.of("5 symbols word with -",PreTextTestSetup.textWord5LettersWithDash,5)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsForListing")
    void parseTextWithDelimiterListing(String title, String source, int countListing) {
        TextComponent mainComponent = new TextComponent(source);
        parser.parseWithDelimiter(mainComponent, TextComponentType.LISTING, TextComponentType.TEXT, false);
        Assertions.assertEquals(countListing, mainComponent.getEach(TextComponentType.LISTING).size());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsForParagraph")
    void parseTextWithDelimiterParagraph(String title, String source, int countParagraph, int countDelimiter) {
        TextComponent mainComponent = new TextComponent(source);
        parser.parseWithDelimiter(mainComponent, TextComponentType.PARAGRAPH_DELIMITER, TextComponentType.PARAGRAPH, false);
        Assertions.assertEquals(countParagraph, mainComponent.getEach(TextComponentType.PARAGRAPH).size());
        Assertions.assertEquals(countDelimiter, mainComponent.getEach(TextComponentType.PARAGRAPH_DELIMITER).size());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsForSentence")
    void parseTextWithDelimiterSentence(String title, String source, int countSentence, int countDelimiter) {
        TextComponent mainComponent = new TextComponent(source);
        parser.parseWithDelimiter(mainComponent, TextComponentType.SENTENCE_DELIMITER, TextComponentType.SENTENCE, false);
        Assertions.assertEquals(countSentence, mainComponent.getEach(TextComponentType.SENTENCE).size());
        Assertions.assertEquals(countDelimiter, mainComponent.getEach(TextComponentType.SENTENCE_DELIMITER).size());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsForWordWithPunctuation")
    void parseTextWithDelimiterWordWithPunctuation(String title, String source, int countWordWithPunctuation, int countDelimiter) {
        TextComponent mainComponent = new TextComponent(source);
        parser.parseWithDelimiter(mainComponent, TextComponentType.WORD_DELIMITER, TextComponentType.WORD_WITH_PUNCTUATION, false);
        Assertions.assertEquals(countWordWithPunctuation, mainComponent.getEach(TextComponentType.WORD_WITH_PUNCTUATION).size());
        Assertions.assertEquals(countDelimiter, mainComponent.getEach(TextComponentType.WORD_DELIMITER).size());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsForPunctuation")
    void parseTextWithDelimiterPunctuation(String title, String source, int countWord, int countPunctuation) {
        TextComponent mainComponent = new TextComponent(source);
        parser.parseWithDelimiter(mainComponent, TextComponentType.PUNCTUATION, TextComponentType.WORD, true);
        Assertions.assertEquals(countWord, mainComponent.getEach(TextComponentType.WORD).size());
        Assertions.assertEquals(countPunctuation, mainComponent.getEach(TextComponentType.PUNCTUATION).size());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsForLetter")
    void parseLetter(String title, String source, int countLetter) {
        TextComponent mainComponent = new TextComponent(source);
        parser.parse(mainComponent, TextComponentType.SYMBOL);
        Assertions.assertEquals(countLetter, mainComponent.getEach(TextComponentType.SYMBOL).size());
    }
}
