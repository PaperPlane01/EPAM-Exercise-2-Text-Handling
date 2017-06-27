package kz.javalab.texthandling.text.entity.impl.sentencepart.impl.word;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.symbol.Symbol;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;

import java.util.ArrayList;
import java.util.List;

public class Word extends SentencePart implements Text {

    private List<Symbol> symbols = new ArrayList<>();

    public Word() {
    }

    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();

        for (Symbol symbol : symbols) {
            stringBuffer.append(symbol.getContent());
        }

        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Word{" +
                "symbols=" + symbols +
                '}';
    }
}
