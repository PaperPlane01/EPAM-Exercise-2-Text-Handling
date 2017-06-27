package kz.javalab.texthandling.text.entity.impl.sentencepart.impl.punctuation;

import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;
import kz.javalab.texthandling.text.entity.impl.symbol.Symbol;

import java.util.List;

/**
 * Created by Администратор on 26.06.2017.
 */
public class Punctuation extends SentencePart implements Text {

    private List<Symbol> symbols;

    public Punctuation() {
    }

    public Punctuation(List<Symbol> symbols) {
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
        return "Punctuation{" +
                "symbols=" + symbols +
                '}';
    }
}
