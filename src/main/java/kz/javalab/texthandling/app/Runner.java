package kz.javalab.texthandling.app;

import kz.javalab.texthandling.telegram.entity.Telegram;
import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.entity.impl.CompoundText;
import kz.javalab.texthandling.text.io.TextReader;
import kz.javalab.texthandling.text.io.TextWriter;
import kz.javalab.texthandling.view.impl.TelegramView;

public class Runner {

    private static final String INPUT_TEXT_FILE = "text.txt";
    private static final String OUTPUT_TEXT_FILE = "output.txt";

    public static void main(String[] args)  {
        TextReader textReader = new TextReader(INPUT_TEXT_FILE);

        Text text = textReader.readText();


        TextWriter textWriter = new TextWriter(OUTPUT_TEXT_FILE, text);
        textWriter.writeText();

        double pricePerWord = 0.1;
        Telegram telegram = new Telegram((CompoundText) text, pricePerWord);
        TelegramView telegramView = new TelegramView(telegram);
        telegramView.show();
    }
}
