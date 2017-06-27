package kz.javalab.texthandling.text.io;


import kz.javalab.texthandling.text.entity.Text;

import java.io.*;

public class TextWriter {

    private String filePath;
    private Text text;

    public TextWriter() {
    }

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

    public void writeText() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new StringReader(text.getContent()));
        PrintWriter printWriter = new PrintWriter(new FileWriter(filePath));

        bufferedReader.lines().forEach(line -> printWriter.println(line));

        printWriter.flush();
        printWriter.close();

        bufferedReader.close();

    }
}
