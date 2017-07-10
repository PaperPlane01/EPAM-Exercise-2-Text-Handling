package kz.javalab.texthandling.view.impl;


import kz.javalab.texthandling.text.analyzer.TextAnalyzer;
import kz.javalab.texthandling.text.entity.impl.sentencepart.impl.Word;
import kz.javalab.texthandling.view.View;

import java.util.List;

/**
 * This class is designated to visually represent content of <Code>TextAnalyzer</Code> instance.
 */
public class TextAnalyzerView implements View {

    private TextAnalyzer textAnalyzer = new TextAnalyzer();

    public TextAnalyzerView() {
    }

    public TextAnalyzerView(TextAnalyzer textAnalyzer) {
        this.textAnalyzer = textAnalyzer;
    }

    public TextAnalyzer getTextAnalyzer() {
        return textAnalyzer;
    }

    public void setTextAnalyzer(TextAnalyzer textAnalyzer) {
        this.textAnalyzer = textAnalyzer;
    }

    @Override
    public void show() {
        showListOfShortestWords();
        showListOfLongestWords();
    }

    private void showListOfShortestWords() {
        List<Word> shortestWords = textAnalyzer.getListOfShortestWords();
        System.out.println("List of shortest words : ");

        for (Word word : shortestWords) {
            TextView textView = new TextView(word);
            textView.show();
        }
    }

    private void showListOfLongestWords() {
        List<Word> listOfLongestWords = textAnalyzer.getListOfLongestWords();
        System.out.println("List of longest words: ");

        for (Word word : listOfLongestWords) {
            TextView textView = new TextView(word);
            textView.show();
        }
    }
    
}
