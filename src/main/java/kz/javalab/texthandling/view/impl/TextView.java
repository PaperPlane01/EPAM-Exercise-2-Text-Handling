package kz.javalab.texthandling.view.impl;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.view.View;

/**
 * This class is designated to visually represent content of <Code>Text</Code> instance.
 */
public class TextView implements View {

    private Text text;

    public TextView() {

    }

    public TextView(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    /**
     * Shows data contained in <Code>Text</Code> instance.
     */
    @Override
    public void show() {
        System.out.println(text);
    }
}
