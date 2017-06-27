package kz.javalab.texthandling.text.io;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.parser.TextParser;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reads text from the file and creates <Code>Text</Code> instance from it. The text parsing is delegated to <Code>TextParser</Code>.
 */
public class TextReader {

    /**
     * Path of the file.
     */
    private String filePath;

    /**
     * Creates an instance of <Code>TextReader</Code>.
     */
    public TextReader() {
    }

    /**
     * Creates an instance of <Code>TextReader</Code>.
     * @param filePath Path of the file containing text information.
     */
    public TextReader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads text from the file and creates <Code>Text</Code> instance from it. The text parsing is delegated to <Code>TextParser</Code>
     * @return Parsed text.
     * @throws IOException If something went wrong...
     */
    public Text readText() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();

        List<String> lines = Files.lines(Paths.get(filePath)).collect(Collectors.toList());

        lines.forEach(line -> stringBuffer.append(line).append("\n"));

        TextParser textParser = new TextParser(stringBuffer.toString());

        return textParser.parseText();
    }
}
