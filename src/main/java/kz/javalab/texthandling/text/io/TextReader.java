package kz.javalab.texthandling.text.io;


import kz.javalab.texthandling.text.entity.Text;
import kz.javalab.texthandling.text.parser.TextParser;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
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
     * Reads text from the file and creates <Code>Text</Code> instance from it. The text parsing is delegated to <Code>TextParser</Code>.
     * @return Parsed text.
     */
    public Text readText()  {
        StringBuffer stringBuffer = new StringBuffer();

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filePath);
            int characterCode;

            while ((characterCode = fileReader.read()) != -1) {
                stringBuffer.append((char) characterCode);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return (new TextParser(stringBuffer.toString())).parseText();

    }
}
