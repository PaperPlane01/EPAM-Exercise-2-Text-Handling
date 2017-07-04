package kz.javalab.texthandling.view.impl;


import kz.javalab.texthandling.text.analyzer.TextAnalyzer;
import kz.javalab.texthandling.text.entity.impl.sentencepart.impl.Word;
import kz.javalab.texthandling.view.View;

import java.util.List;

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
        showListOfWordsWithMinimumLength();
        showListOfWordsWithMaximumLength();
    }

    private void showListOfWordsWithMinimumLength() {
        List<Word> wordsWithMinimumLength = textAnalyzer.getListOfWordsWithMinimumLength();
        showMessage("List of words with minimum length: ");

        for (Word word : wordsWithMinimumLength) {
            TextView textView = new TextView(word);
            textView.show();
        }
    }

    private void showListOfWordsWithMaximumLength() {
        List<Word> wordsWithMaximumLength = textAnalyzer.getListOfWordsWithMaximumLength();
        showMessage("List of words with maximum length: ");

        for (Word word : wordsWithMaximumLength) {
            TextView textView = new TextView(word);
            textView.show();
        }
    }

    private void showMessage(String message) {
        System.out.println(message);
    }
}
