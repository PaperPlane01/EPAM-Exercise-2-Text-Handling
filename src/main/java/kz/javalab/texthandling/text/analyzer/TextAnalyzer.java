package kz.javalab.texthandling.text.analyzer;

import kz.javalab.texthandling.text.entity.impl.CompoundText;
import kz.javalab.texthandling.text.entity.impl.Paragraph;
import kz.javalab.texthandling.text.entity.impl.Sentence;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;
import kz.javalab.texthandling.text.entity.impl.sentencepart.impl.Word;

import java.util.ArrayList;
import java.util.List;


public class TextAnalyzer {
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

    public List<Word> getListOfWordsWithMinimumLength() {
        List<Word> wordsContainedInText = getListOfWordsContainedInText();
        List<Word> wordsWithMinimumLength = new ArrayList<>();

        int minimumLength = countMinimumLengthOfWord();

        for (Word word: wordsContainedInText) {
            if (word.getLength() == minimumLength) {
                wordsWithMinimumLength.add(word);
            }
        }

        return wordsWithMinimumLength;
    }

    public List<Word> getListOfWordsWithMaximumLength() {
        List<Word> wordsContainedInText = getListOfWordsContainedInText();
        List<Word> wordsWithMaximumLength = new ArrayList<>();

        int maximumLength = countMaximumLengthOfWord();

        for (Word word : wordsContainedInText) {
            if (word.getLength() == maximumLength) {
                wordsWithMaximumLength.add(word);
            }
        }

        return wordsWithMaximumLength;
    }

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
