package kz.javalab.texthandling.text.entity.impl.symbol;


import kz.javalab.texthandling.text.entity.Text;

public class Symbol implements Text {

    private Character value;

    public Symbol() {
    }

    public Symbol(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    @Override
    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(value);

        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "value=" + value +
                '}';
    }
}
