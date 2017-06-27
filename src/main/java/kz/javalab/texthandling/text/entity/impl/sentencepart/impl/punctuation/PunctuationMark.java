package kz.javalab.texthandling.text.entity.impl.sentencepart.impl.punctuation;

import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;
import kz.javalab.texthandling.text.entity.impl.symbol.Symbol;

import java.util.List;


/**
 * This class represents a punctuation mark (whitespace character is also included) of the sentense.
 */
public class PunctuationMark extends SentencePart implements Text {

    /**
     * Value of the punctuation mark.
     */
    private Symbol value;

    /**
     * Creates an instance of <Code>PunctuationMark</Code>.
     */
    public PunctuationMark() {
    }

    /**
     * Creates an instance of <Code>PunctuationMark</Code> with specified value.
     * @param value Value of the punctuation mark.
     */
    public PunctuationMark(Symbol value) {
        this.value = value;
    }

    /**
     * Allows to get access to the value of the punctuation mark.
     * @return Value of the punctuation mark.
     */
    public Symbol getValue() {
        return value;
    }

    /**
     * Allows to set a new value to the punctuation mark.
     * @param value New value to be set.
     */
    public void setValue(Symbol value) {
        this.value = value;
    }

    /**
     * Creates a string representation of content of the punctuation mark.
     * @return String representation of content of the punctuation mark.
     */
    @Override
    public String getContent() {
        return value.getContent();
    }

    /**
     * Creates a string representation of <Code>PunctuationMark</Code> instance.
     * @return String representation of <Code>PunctuationMark</Code> instance.
     */
    @Override
    public String toString() {
        return "PunctuationMark{" +
                "value=" + value +
                '}';
    }
}
