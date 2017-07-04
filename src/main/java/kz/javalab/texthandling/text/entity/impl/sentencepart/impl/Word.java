package kz.javalab.texthandling.text.entity.impl.sentencepart.impl;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.Symbol;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;

import java.util.ArrayList;
import java.util.List;

/**
        * This class represents a word.
        */
public class Word extends SentencePart implements Text {

    /**
     * Symbols of the word.
     */
    private List<Symbol> symbols = new ArrayList<>();

    /**
     * Creates an instance of <Code>Word</Code>.
     */
    public Word() {
    }

    /**
     * Creates an instance of <Code>Word</Code> with specified symbols.
     * @param symbols
     */
    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    /**
     * Allows to get access to the symbols of the word.
     * @return Symbols of the word.
     */
    public List<Symbol> getSymbols() {
        return symbols;
    }

    /**
     * Allows to set new symbols to the word.
     * @param symbols
     */
    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public Symbol getLetterAt(int index) {
        return symbols.get(index);
    }

    public void setLetterAt(int index, Symbol letter) {
        symbols.set(index, letter);
    }

    public int getLength() {
        return symbols.size();
    }

    /**
     * Creates a string representation of content of the word.
     * @return String representation of content of the word.
     */
    @Override
    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();

        for (Symbol symbol : symbols) {
            stringBuffer.append(symbol.getContent());
        }

        return stringBuffer.toString();
    }

    /**
     * Creates a string representation of <Code>Word</Code> instance.
     * @return String representation of <Code>Word</Code> instance.
     */
    @Override
    public String toString() {
        return "Word{" +
                "symbols=" + symbols +
                '}';
    }
}
