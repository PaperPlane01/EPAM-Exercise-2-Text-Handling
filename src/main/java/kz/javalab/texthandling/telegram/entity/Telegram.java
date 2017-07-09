package kz.javalab.texthandling.telegram.entity;

import kz.javalab.texthandling.text.analyzer.TextAnalyzer;
import kz.javalab.texthandling.text.entity.impl.CompoundText;

/**
 * Created by Администратор on 10.07.2017.
 */
public class Telegram {

    private CompoundText content = new CompoundText();
    private int pricePerWord;

    public Telegram() {
    }

    public Telegram(CompoundText content, int pricePerWord) {
        this.content = content;
        this.pricePerWord = pricePerWord;
    }

    public CompoundText getContent() {
        return content;
    }

    public void setContent(CompoundText content) {
        this.content = content;
    }

    public int getPricePerWord() {
        return pricePerWord;
    }

    public void setPricePerWord(int pricePerWord) {
        this.pricePerWord = pricePerWord;
    }

    public int getPrice() {
        TextAnalyzer textAnalyzer = new TextAnalyzer(content);
        int numberOfWords = textAnalyzer.getNumberOfWords();
        return numberOfWords * pricePerWord;
    }
}
