package kz.javalab.texthandling.text.parser;

import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.CompoundText;
import kz.javalab.texthandling.text.entity.impl.Paragraph;
import kz.javalab.texthandling.text.entity.impl.Sentence;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;
import kz.javalab.texthandling.text.entity.impl.sentencepart.impl.PunctuationMark;
import kz.javalab.texthandling.text.entity.impl.Symbol;
import kz.javalab.texthandling.text.entity.impl.sentencepart.impl.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextParser {

    /**
     * String to be parsed.
     */
    private String textAsString;
    /**
     * Pattern for paragraphs.
     */
    private static final Pattern PARAGRAPH_PATTERN = Pattern.compile(".*[\\n]*", Pattern.MULTILINE | Pattern.COMMENTS);
    /**
     * Pattern for sentences.
     */
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^:.!?]*)*[.!?]?['\"]?[\\s]*(?=|[\\n\\s]*$)", Pattern.MULTILINE | Pattern.COMMENTS);
    /**
     * Pattern for part of the sentences. Part of the sentence is considered as word plus any punctuation mark (including whitespace character).
     */
    private static final Pattern SENTENCE_PART_PATTERN = Pattern.compile("[\\wа-яА-ЯёЁ]*[\\w'а-яА-ЯёЁ\\-)]?[\\s]*([?!…\"#$%&'().«»*–—+,\\-.:;<=>@^_`[{|}]])*[\\s]*[\\n]*");
    /**
     * Pattern for words.
     */
    private static final Pattern WORD_PATTERN = Pattern.compile("((\\b[^\\s]+\\b)((?<=\\.[\\w\\-']).)?)");
    /**
     * Pattern for punctuation marks.
     */
    private static final Pattern PUNCTUATION_PATTERN = Pattern.compile("([\\s?!…\\\"#$%&'().«»*–—+,\\-:;<=>@^_`[{|}]])");

    private TextParser() {
    }

    /**
     * Creates an instance of <Code>TextParser class.</Code>
     * @param textAsString Text information which is to be parsed.
     */
    public TextParser(String textAsString) {
        this.textAsString = textAsString;
    }

    public String getTextAsString() {
        return textAsString;
    }

    public void setTextAsString(String textAsString) {
        this.textAsString = textAsString;
    }

    /**
     * Creates an instance of <Code>Text</Code> interface which is parsed from the string specified in constructor.
     * @return Instance of <Code>Text</Code> parsed from the string.
     */
    public Text parseText() {
        return this.parseText(textAsString);
    }

    /**
     * Creates an instance of <Code>Text</Code> interface which is parsed from the specified string.
     * @param textAsString String to be parsed.
     * @return Instance of <Code>Text</Code> parsed from the string.
     */
    private Text parseText(String textAsString) {
        CompoundText text = new CompoundText();

        List<Paragraph> paragraphs = parseParagraphs(textAsString);

        text.setParagraphs(paragraphs);

        return text;
    }

    /**
     * Creates a list of paragraphs parsed from the text.
     * @param textAsString String representation of text.
     * @return List of paragraphs parsed from the text.
     */
    private List<Paragraph> parseParagraphs(String textAsString) {
        List<String> paragraphsAsStrings = new ArrayList<>();
        List<Paragraph> paragraphs = new ArrayList<>();

        Matcher paragraphMatcher = PARAGRAPH_PATTERN.matcher(textAsString);

        while (paragraphMatcher.find()) {
            paragraphsAsStrings.add(paragraphMatcher.group());
        }

        for (String paragraphAsString : paragraphsAsStrings) {
            Paragraph paragraph = new Paragraph();
            List<Sentence> sentences = parseSentences(paragraphAsString);
            paragraph.setSentences(sentences);
            paragraphs.add(paragraph);
        }

        return paragraphs;
    }

    /**
     * Creates a list of sentences parsed from the string representation of paragraph.
     * @param paragraphAsString String representation of paragraph.
     * @return List of sentences parsed from the string representation of paragraph.
     */
    private List<Sentence> parseSentences(String paragraphAsString) {
        List<String> sentencesAsStrings = new ArrayList<>();
        List<Sentence> sentences = new ArrayList<>();

        Matcher sentenceMatcher = SENTENCE_PATTERN.matcher(paragraphAsString);

        while (sentenceMatcher.find()) {
            sentencesAsStrings.add(sentenceMatcher.group());
        }

        for (String sentenceAsString : sentencesAsStrings) {
            List<SentencePart> sentenceParts = parseSentenceParts(sentenceAsString);
            Sentence sentence = new Sentence(sentenceParts);
            sentences.add(sentence);
        }

        return sentences;
    }

    /**
     * Creates a list of sentence parts (word + punctuation) parsed from the string representation of sentence.
     * @param sentenceAsString String representation of sentence.
     * @return List of sentence parts parsed from the string representation of sentence.
     */
    private List<SentencePart> parseSentenceParts(String sentenceAsString) {
        List<SentencePart> sentenceParts = new ArrayList<>();

        List<String> sentencePartsAsStrings = new ArrayList<>();

        Matcher sentencePartMatcher = SENTENCE_PART_PATTERN.matcher(sentenceAsString);

        while (sentencePartMatcher.find()) {
            sentencePartsAsStrings.add(sentencePartMatcher.group());
        }

        for (String sentencePartAsString : sentencePartsAsStrings) {

            Matcher wordMatcher = WORD_PATTERN.matcher(sentencePartAsString);
            Matcher punctuationMatcher = PUNCTUATION_PATTERN.matcher(sentencePartAsString);

            while (wordMatcher.find()) {
                Word word = parseWord(wordMatcher.group());
                sentenceParts.add(word);

                while (punctuationMatcher.find()) {
                    for (int index = 0; index < punctuationMatcher.group().length(); index++) {
                        PunctuationMark punctuationMark = parsePunctuation(punctuationMatcher.group().charAt(index));
                        sentenceParts.add(punctuationMark);
                    }
                }

            }

        }

        return sentenceParts;
    }

    /**
     * Creates an instance of <Code>Word</Code> class parsed from the string representation of word.
     * @param wordAsString String representation of word.
     * @return Instance of <Code>Word</Code> class parsed from the string representation of word.
     */
    private Word parseWord(String wordAsString) {
        List<Symbol> symbols = new ArrayList<>();

        for (int index = 0; index < wordAsString.length(); index++) {
            Symbol symbol = parseSymbol(wordAsString.charAt(index));
            symbols.add(symbol);
        }

        return new Word(symbols);
    }

    /**
     * Creates an instance of <Code>PunctuationMark</Code> class parsed from the string representation of punctuation marks.
     * @param punctuation String representation of punctuation marks.
     * @return Instance of <Code>PunctuationMark</Code> class parsed from the string representation of punctuation marks.
     */
    private PunctuationMark parsePunctuation(Character punctuation) {
        Symbol symbol = new Symbol(punctuation);

        return new PunctuationMark(symbol);
    }

    /**
     * Creates an instance of <Code>Symbol</Code> class parsed from the <Ccode>Character</Ccode> representation of symbol.
     * @param symbolValue Character to be parsed.
     * @return Instance of <Code>Symbol</Code> class parsed from the <Ccode>Character</Ccode> representation of symbol.
     */
    private Symbol parseSymbol(Character symbolValue) {
        return new Symbol(symbolValue);
    }
}
