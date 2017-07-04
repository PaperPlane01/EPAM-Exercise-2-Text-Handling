package kz.javalab.texthandling.text.entity.impl;


import kz.javalab.texthandling.text.entity.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a paragraph of the text.
 */
public class Paragraph implements Text {

    /**
     * Sentences of the paragraph.
     */
    private List<Sentence> sentences = new ArrayList();

    /**
     * Creates an instance of <Code>Paragraph</Code>.
     */
    public Paragraph() {
    }

    /**
     * Creates an instance of <Code>Paragraph</Code> with specified list of sentences.
     * @param sentences List of sentences.
     */
    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    /**
     * Allows to get access to the sentences of the paragraph.
     * @return Sentences of the paragraph.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Allows to set new sentences to the paragraph.
     * @param sentences New sentences which are to be set.
     */
    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    /**
     * Allows to add a new sentence to the paragraph.
     * @param sentence New sentence to be added.
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Removes a sentence with specified index.
     * @param index Index of the sentence which is to be removed.
     */
    public void removeSentence(int index) {
        try {
            sentences.remove(index);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates string representation of content of the paragraph.
     * @return String representation of content of the paragraph.
     */
    @Override
    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();

        for (Sentence sentence : sentences) {
            stringBuffer.append(sentence.getContent());
        }

        return stringBuffer.toString();
    }

    /**
     * Creates a string representation of <Code>Paragraph</Code> instance.
     * @return String representation of <Code>Paragraph</Code> instance.
     */
    @Override
    public String toString() {
        return "Paragraph{" +
                "sentences=" + sentences +
                '}';
    }
}
