package kz.javalab.texthandling.text.io;


import kz.javalab.texthandling.text.entity.Text;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Writes instance of <Code>Text</Code> to the file.
 */
public class TextWriter {

    /**
     * Target file.
     */
    private String filePath;
    /**
     * Text to be written.
     */
    private Text text;


    private TextWriter() {
    }

    /**
     * Creates instance of <Code>TextWriter</Code>.
     * @param filePath Target file.
     * @param text Text to be written.
     */
    public TextWriter(String filePath, Text text) {
        this.filePath = filePath;
        this.text = text;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    /**
     * Writes instance of <Code>Text</Code> to the file.
     */
    public void writeText()  {

        BufferedWriter bufferedWriter = null;

        try {
           bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),
                    Charset.forName("UTF-8")));
           bufferedWriter.write(text.toString());
           bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
