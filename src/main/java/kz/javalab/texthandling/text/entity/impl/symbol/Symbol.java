package kz.javalab.texthandling.text.entity.impl.symbol;


import kz.javalab.texthandling.text.entity.Text;

/**
 * This class represents a symbol.
 */
public class Symbol implements Text {

    /**
     * Value of the symbol.
     */
    private Character value;

    /**
     * Creates an instance of <Code>Symbol</Code>.
     */
    public Symbol() {
    }

    /**
     * Creates an instance of <Code>Symbol</Code> with specified value.
     * @param value Value of the symbol.
     */
    public Symbol(Character value) {
        this.value = value;
    }

    /**
     * Allows to get access to the value of the symbol.
     * @return Value of the symbol.
     */
    public Character getValue() {
        return value;
    }

    /**
     * Allows to set a new value to the punctuation mark.
     * @param value New value to be set.
     */
    public void setValue(Character value) {
        this.value = value;
    }

    /**
     * Creates a string representation of content of the symbol.
     * @return String representation of content of the symbol.
     */
    @Override
    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();
        
        stringBuffer.append(value);

        return stringBuffer.toString();
    }

    /**
     * Creates a string representation of <Code>Symbol</Code> instance.
     * @return String representation of <Code>Symbol</Code> instance.
     */
    @Override
    public String toString() {
        return "Symbol{" +
                "value=" + value +
                '}';
    }
}
