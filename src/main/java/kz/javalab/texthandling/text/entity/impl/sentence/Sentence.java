package kz.javalab.texthandling.text.entity.impl.sentence;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a sentence.
 */
public class Sentence implements Text {

    /**
     * Parts of the sentence. A part of sentence is a word or punctuation mark.
     */
    private List<SentencePart> sentenceParts = new ArrayList<>();

    /**
     * Creates an instance of <Code>Sentence</Code>.
     */
    public Sentence() {
    }

    /**
     * Creates an instance of <Code>Sentence</Code> with specified sentence parts.
     * @param sentenceParts Parts of the sentence. A part of sentence is a word or punctuation mark.
     */
    public Sentence(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    /**
     * Allows to get access to parts of the sentence.
     * @return Parts of the sentence.
     */
    public List<SentencePart> getSentenceParts() {
        return sentenceParts;
    }

    /**
     * Allows to set new sentence parts to the sentence.
     * @param sentenceParts
     */
    public void setSentenceParts(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    @Override
    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();

        for (SentencePart sentencePart : sentenceParts) {
            stringBuffer.append(sentencePart.getContent());
        }

        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentenceParts=" + sentenceParts +
                '}';
    }
}
