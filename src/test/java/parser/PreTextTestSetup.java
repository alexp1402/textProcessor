package parser;

public class PreTextTestSetup {
    public static String textFull = "Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
            "\n" +
            "Пример создания матчера приведен ниже.\n" +
            "{code}\n" +
            "Pattern p = Pattern.compile(\"a*b\");// скомпилировали регулярное выражение в представление\n" +
            "Matcher m = p.matcher(\"aaaaab\");//создали поисковик в тексте “aaaaab” по шаблону \"a*b\"\n" +
            "\n {/code}\n" +
            "Теперь с помощью нашего «поисковика» мы можем искать совпадения. Узнавать позицию совпадения в тексте. Заменять текст с помощью методов класса.\n" +
            "\n" +
            "Метод boolean find() ищет очередное совпадение в тексте с шаблоном. Вам надо найти соопадение? С помощью этого метода и оператора цикла можно производить анализ всего текста по событийной модели осуществлять необходимые операции при наступлении события.";

    public static String textWith2Code ="Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
            "\n" +
            "Пример {code}создания матчера приведен ниже.\n" +
            "Теперь с помощью нашего «поисковика»{/code} мы можем искать совпадения. Узнавать позицию совпадения в тексте. Заменять текст с помощью методов класса.\n" +
            "\n" +
            "Метод boolean find() ищет очередное {code}совпадение в тексте с шаблоном.{/code} Вам надо найти соопадение? С помощью этого метода и оператора цикла можно производить анализ всего текста по событийной модели осуществлять необходимые операции при наступлении события.";

    public static String textWithoutCode = "Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
            "\n" +
            "Пример создания матчера приведен ниже.\n" +
            "Теперь с помощью нашего «поисковика» мы можем искать совпадения. Узнавать позицию совпадения в тексте. Заменять текст с помощью методов класса.\n" +
            "\n" +
            "Метод boolean find() ищет очередное совпадение в тексте с шаблоном. Вам надо найти соопадение? С помощью этого метода и оператора цикла можно производить анализ всего текста по событийной модели осуществлять необходимые операции при наступлении события.";

    public static String textWithWrongCode = "Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
            "\n" +
            "Пример создания матчера приведен ниже.\n" +
            "Теперь с помощью нашего {code} «поисковика» мы можем искать совпадения. Узнавать позицию совпадения в тексте. Заменять текст с помощью методов класса.\n" +
            "\n" +
            "Метод boolean find() ищет очередное совпадение в тексте с шаблоном. Вам надо найти соопадение? С помощью этого метода и оператора цикла можно производить анализ всего текста по событийной модели осуществлять необходимые операции при наступлении события.";

    public static String textOneParagraph="Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.";

    public static String textThreeParagraph ="Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher." +
            "\nПример создания матчера приведен ниже.\nПример создания матчера приведен ниже.";

    public static String textFiveParagraph="Шаблоном для поиска является объект класса Pattern, на котором вызывается метод matcher.\n" +
            "\n" +
            "Пример создания матчера приведен ниже.\n"+
            "\nПример";

    public static String textOneSentence="Шаблоном для поиска является объект класса Pattern.";

    public static String textOneSentenceWithout="Шаблоном для поиска является объект класса Pattern";

    public static String textThreeSentences="Шаблоном для поиска является объект класса Pattern. Шаблоном для поиска является объект класса Pattern? Шаблоном для поиска является объект класса Pattern!";

    public static String textThreeSentencesMultiDOT="Шаблоном для поиска является объект класса Pattern. Шаблоном для поиска является объект класса Pattern!! Шаблоном для поиска является объект класса Pattern???";

    //PUNCTUATION("[,-:“;»«)(]"),
    public static String textFiveWordPunctuation="first, second: third) [fourth »five";

    public static String textFiveWord="first second third fourth five";

    public static String textFourWordWith="first-first second third fourth-fourth";

    public static String textWordWithQuotes="«word»";
    public static String textWordWithQuotes2="“word“";
    public static String textWordWithBrackets="(word)";
    public static String textWordWithSemicolon="word;";
    public static String textWordWithColon="word:";
    public static String textWordWithDash="word-";
    public static String textWordClean="word";
    public static String textWord5Letters="abcde";
    public static String textWord1Letters="a";
    public static Object textWord5LettersWithDash="ab-de";
}
