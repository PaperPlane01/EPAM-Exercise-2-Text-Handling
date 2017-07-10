package kz.javalab.texthandling.text.analyzer;

import kz.javalab.texthandling.text.entity.impl.CompoundText;
import kz.javalab.texthandling.text.entity.impl.Paragraph;
import kz.javalab.texthandling.text.entity.impl.Sentence;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;
import kz.javalab.texthandling.text.entity.impl.sentencepart.impl.Word;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is designated for analyzing the text.
 */
public class TextAnalyzer {
    /**
     * Text to be analyzed.
     */
    private CompoundText text = new CompoundText();

    public TextAnalyzer() {
    }

    public TextAnalyzer(CompoundText text) {
        this.text = text;
    }

    public CompoundText getText() {
        return text;
    }

    public void setText(CompoundText text) {
        this.text = text;
    }

    /**
     * Allows to know how many words are contained in the text.
     * @return Number of words contained in text.
     */
    public int getNumberOfWords() {
        return getListOfWordsContainedInText().size();
    }

    /**
     * Returns list of shortest words.
     * @return List of shortest words.
     */
    public List<Word> getListOfShortestWords() {
        List<Word> wordsContainedInText = getListOfWordsContainedInText();
        List<Word> shortestWords = new ArrayList<>();

        int minimumLength = countMinimumLengthOfWord();

        for (Word word: wordsContainedInText) {
            if (word.getLength() == minimumLength) {
                shortestWords.add(word);
            }
        }

        return shortestWords;
    }

    /**
     * Returns the list of longest words.
     * @return List of longest words.
     */
    public List<Word> getListOfLongestWords() {
        List<Word> wordsContainedInText = getListOfWordsContainedInText();
        List<Word> longestWords = new ArrayList<>();

        int maximumLength = countMaximumLengthOfWord();

        for (Word word : wordsContainedInText) {
            if (word.getLength() == maximumLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }

    /**
     * Counts the minimum length of word.
     * @return Minimum length of word.
     */
    private int countMinimumLengthOfWord() {
        List<Word> words = getListOfWordsContainedInText();

        Word shortestWord = words.get(0);

        for (Word word : words) {
            if (word.getLength() < shortestWord.getLength()) {
                shortestWord = word;
            }
        }

        return  shortestWord.getLength();
    }

    /**
     * Counts the maximum length of word.
     * @return Maximum length of word.
     */
    private int countMaximumLengthOfWord() {
        List<Word> words = getListOfWordsContainedInText();

        Word longestWord = words.get(0);

        for (Word word : words) {
            if (word.getLength() > longestWord.getLength()) {
                longestWord = word;
            }
        }

        return longestWord.getLength();
    }

    private List<Word> getListOfWordsContainedInText() {
        List<Word> words = new ArrayList<>();

        for (Paragraph paragraph : text.getParagraphs()) {
            for (Sentence sentence : paragraph.getSentences()) {
                for (SentencePart sentencePart : sentence.getSentenceParts()) {
                    if (sentencePart instanceof Word) {
                        words.add((Word) sentencePart);
                    }
                }
            }
        }

        return words;
    }



}
