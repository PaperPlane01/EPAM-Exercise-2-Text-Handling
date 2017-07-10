package kz.javalab.texthandling.text.entity.impl.sentencepart.impl;

import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.Symbol;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;


/**
 * This class represents a punctuation mark (whitespace character is also included) of the sentense.
 */
public class PunctuationMark implements SentencePart {

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
     * Creates a string representation of <Code>PunctuationMark</Code> instance.
     * @return String representation of <Code>PunctuationMark</Code> instance.
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
