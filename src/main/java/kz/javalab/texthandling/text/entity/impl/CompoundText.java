package kz.javalab.texthandling.text.entity.impl;

import kz.javalab.texthandling.text.entity.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a text consisting of paragraphs.
 */
public class CompoundText implements Text {

    /**
     * Paragraphs of the text.
     */
    private List<Paragraph> paragraphs = new ArrayList<>();

    /**
     * Creates an instance of <Code>CompoundText</Code>.
     */
    public CompoundText() {

    }

    /**
     * Creates an instance of <Code>CompoundText</Code> with specified paragraphs.
     * @param paragraphs List of paragraphs of the text.
     */
    public CompoundText(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public int getNumberOfParagraphs() {
        return this.paragraphs.size();
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    /**
     * Allows to add a new paragraph to the text.
     * @param paragraph Paragraph to be added.
     */
    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    /**
     * Removes paragraph with the specified index.
     * @param index Index of the paragraph which is to be removed.
     */
    public void removeParagraph(int index) {
        try {
            paragraphs.remove(index);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates a string representation of <Code>CompoundText</Code> instance.
     * @return String representation of <Code>CompoundText</Code> instance.
     */
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        for (Paragraph paragraph : paragraphs) {
            stringBuffer.append(paragraph.toString());
        }

        return stringBuffer.toString();
    }
}

