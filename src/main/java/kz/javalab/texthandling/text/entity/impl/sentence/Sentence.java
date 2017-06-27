package kz.javalab.texthandling.text.entity.impl.sentence;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.sentencepart.SentencePart;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Text {

    private List<SentencePart> sentenceParts = new ArrayList<>();

    public Sentence() {
    }

    public Sentence(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public List<SentencePart> getSentenceParts() {
        return sentenceParts;
    }

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
