package kz.javalab.texthandling.app;

import kz.javalab.texthandling.telegram.entity.Telegram;
import kz.javalab.texthandling.text.analyzer.TextAnalyzer;
import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.CompoundText;
import kz.javalab.texthandling.text.io.TextReader;
import kz.javalab.texthandling.text.io.TextWriter;
import kz.javalab.texthandling.view.impl.TelegramView;
import kz.javalab.texthandling.view.impl.TextAnalyzerView;
import kz.javalab.texthandling.view.impl.TextView;

import java.io.IOException;


public class Runner {

    private static final String INPUT_TEXT_FILE = "text.txt";
    private static final String OUTPUT_TEXT_FILE = "output.txt";

    public static void main(String[] args) throws IOException {
        TextReader textReader = new TextReader(INPUT_TEXT_FILE);

        Text text = textReader.readText();
        
        TextWriter textWriter = new TextWriter(OUTPUT_TEXT_FILE, text);
        textWriter.writeText();

        int pricePerWord = 100;
        Telegram telegram = new Telegram((CompoundText) text, pricePerWord);
        TelegramView telegramView = new TelegramView(telegram);
        telegramView.show();
    }
}
