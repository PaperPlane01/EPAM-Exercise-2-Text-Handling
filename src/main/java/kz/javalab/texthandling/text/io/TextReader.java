package kz.javalab.texthandling.text.io;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.parser.TextParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextReader {

    private String filePath;

    public TextReader() {

    }

    public TextReader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Text readText() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();

        List<String> lines = Files.lines(Paths.get(filePath)).collect(Collectors.toList());

        lines.forEach(line -> stringBuffer.append(line).append("\n"));

        TextParser textParser = new TextParser(stringBuffer.toString());

        return textParser.parseText();
    }
}
