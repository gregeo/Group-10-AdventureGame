/*
 *  todo: add logger support
 */
package textgame;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Drew Ingelson, George Smith
 */
public class FileSaveLoad {

    private final String fileLocation;
    private String content;

    /**
     * Designed to be an extendable class that sets the basics of saving a file
     * to the rest of the system, handles basic saving and loading also stores
     * copy of file contents in content.
     *
     * @param filePath path to the file not including the file name
     * @param fileName the name of the file
     */
    public FileSaveLoad(String filePath, String fileName) throws IOException {
        if (filePath == null || filePath == "") {
            this.fileLocation = fileName + ".txt";
        } else {
            this.fileLocation = filePath + "\\" + fileName + ".txt"; //Add together the filePath and fileName parameters to get a complete file path
        }
        this.content = null;
        File f = new File(this.fileLocation);

        if (!f.exists() && !f.isDirectory()) {// if the file does not exist make a blank file
            f.createNewFile();
        }
    }

    /**
     * loads file to content(to memory).
     *
     * @throws IOException
     */
    public String FileLoad() throws IOException {

        String temporaryContent = "";

        try (FileReader file = new FileReader(this.fileLocation)) {

            int currentChar;
            do {//read the entier file
                currentChar = file.read();
                if (currentChar != -1) {
                    temporaryContent = temporaryContent + (char) currentChar;
                }
            } while (currentChar != -1);

            file.close();

        } catch (IOException exc) {
            //put error log ineraction here
            throw exc;
        }

        this.content = temporaryContent;
        return this.content;
    }

    /**
     * rewrites the file with the current loaded content.
     *
     * @throws IOException
     */
    public void rewriteFile() throws IOException {
        try (FileWriter file = new FileWriter(this.fileLocation);) {
            file.write(this.content);
            file.close();
        } catch (IOException exc) {
            //add error log here
            throw exc;
        }
    }

    /**
     * sets current content loaded in memory.
     *
     * @param newContent
     */
    public void setContent(String newContent) {
        this.content = newContent;
    }

    /**
     * returns current content loaded in memory.
     *
     * @return
     */
    public String getContent() {//outputs loaded file
        return this.content;
    }

    /**
     * clears content to save memory (as they will sometimes be very big files).
     */
    public void clearContent() {
        this.content = "";
    }

}
