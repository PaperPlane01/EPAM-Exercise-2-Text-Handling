package kz.javalab.texthandling.telegram.entity;

import kz.javalab.texthandling.text.analyzer.TextAnalyzer;
import kz.javalab.texthandling.text.entity.impl.CompoundText;

/**
 * CLass representing telegram.
 */
public class Telegram {

    /**
     * Content of the telegram.
     */
    private CompoundText content = new CompoundText();
    /**
     * Price per word.
     */
    private double pricePerWord;

    public Telegram() {
    }

    /**
     * Creates an instance of <Code>Telegram</Code> with specified content and price per word.
     * @param content Content of the telegram.
     * @param pricePerWord Price per word.
     */
    public Telegram(CompoundText content, double pricePerWord) {
        this.content = content;
        this.pricePerWord = pricePerWord;
    }

    public CompoundText getContent() {
        return content;
    }

    public void setContent(CompoundText content) {
        this.content = content;
    }

    public double getPricePerWord() {
        return pricePerWord;
    }

    public void setPricePerWord(double pricePerWord) {
        this.pricePerWord = pricePerWord;
    }

    /**
     * Counts and returns price of the telegram.
     * @return Price of the telegram.
     */
    public double getPrice() {
        TextAnalyzer textAnalyzer = new TextAnalyzer(content);
        int numberOfWords = textAnalyzer.getNumberOfWords();
        return numberOfWords * pricePerWord;
    }
}
