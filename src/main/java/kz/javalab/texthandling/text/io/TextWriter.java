package kz.javalab.texthandling.text.io;


import kz.javalab.texthandling.text.entity.Text;

import java.io.*;

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
     * @throws IOException If something went wrong.
     */
    public void writeText() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new StringReader(text.getContent()));
        PrintWriter printWriter = new PrintWriter(new FileWriter(filePath));

        bufferedReader.lines().forEach(line -> printWriter.println(line));

        printWriter.flush();
        printWriter.close();

        bufferedReader.close();

    }
}
