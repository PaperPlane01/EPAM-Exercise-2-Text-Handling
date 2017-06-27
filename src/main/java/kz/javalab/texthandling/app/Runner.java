package kz.javalab.texthandling.app;

import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.io.TextReader;
import kz.javalab.texthandling.text.io.TextWriter;
import kz.javalab.texthandling.text.parser.TextParser;
import kz.javalab.texthandling.text.view.impl.TextView;

import java.io.IOException;


public class Runner {

    private static final String INPUT_TEXT_FILE = "text.txt";
    private static final String OUTPUT_TEXT_FILE = "output.txt";

    public static void main(String[] args) throws IOException {
        TextReader textReader = new TextReader(INPUT_TEXT_FILE);

        Text text = textReader.readText();

        TextView textView = new TextView(text);
        textView.show();

        TextWriter textWriter = new TextWriter(OUTPUT_TEXT_FILE, text);
        textWriter.writeText();
    }
}
