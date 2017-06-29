package kz.javalab.texthandling.text.view.impl;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.view.View;

/**
 * This class is designated to visually represent content of <Code>Text</Code> instance.
 */
public class TextView implements View {

    private Text model;

    public TextView() {

    }

    public TextView(Text model) {
        this.model = model;
    }

    public Text getModel() {
        return model;
    }

    public void setModel(Text model) {
        this.model = model;
    }

    /**
     * Shows data contained in <Code>Text</Code> instance.
     */
    @Override
    public void show() {
        System.out.println(model.getContent());
    }
}
