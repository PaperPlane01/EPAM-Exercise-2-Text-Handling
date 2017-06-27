package kz.javalab.texthandling.text.entity.impl.compoundtext;

import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.paragraph.Paragraph;

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
     * Creates string representation of content of the text.
     * @return Content of the text represented as string.
     */
    @Override
    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();

        for (Text paragraph : paragraphs) {
            stringBuffer.append(paragraph.getContent());
            stringBuffer.append("\n");
        }

        return stringBuffer.toString();
    }

    /**
     * Creates a string representation of <Code>CompoundText</Code> instance.
     * @return String representation of <Code>CompoundText</Code> instance.
     */
    @Override
    public String toString() {
        return "CompoundText{" +
                "paragraphs=" + paragraphs +
                '}';
    }
}

