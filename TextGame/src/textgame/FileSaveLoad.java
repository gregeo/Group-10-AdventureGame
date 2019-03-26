/*
 *  todo: add logger support
 */
package textgame;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class used to read a text file for the map
 * 
 */
public class FileSaveLoad{
	//declare class members
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
        if (filePath == null || filePath == "")
		{
			//if no path is provided file location is just the file name
            this.fileLocation = fileName + ".txt";
        }
		else 
		{
			//Add together the filePath and fileName parameters to get a complete file path
            this.fileLocation = filePath + "\\" + fileName + ".txt"; 
        }
		
		//create a new file with the specified location
        this.content = null;
        File f = new File(this.fileLocation);

        if (!f.exists() && !f.isDirectory()) 
		{
			//if the file does not exist make a blank file
            f.createNewFile();
        }
    }

    /**
     * loads file to content(to memory).
     *
     * @throws IOException
     */
    public String FileLoad() throws IOException
	{

        String temporaryContent = "";

		//try to read the file and store all of the information
        try (FileReader file = new FileReader(this.fileLocation))
		{

            int currentChar;
			
			//read the entire file until a negative number comes up
            do 
			{	
				//read the entire file
                currentChar = file.read();
                if (currentChar != -1) 
				{
                    temporaryContent = temporaryContent + (char) currentChar;
                }
            } while (currentChar != -1);

			//close the file reader
            file.close();

        } 
		//catch any file io exception
		catch (IOException exc) 
		{
            //put error log interaction here
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
    public void rewriteFile() throws IOException 
	{
		
		//try to rewrite to the file 
        try (FileWriter file = new FileWriter(this.fileLocation);) 
		{
			//write all of eh content to the file
            file.write(this.content);
            file.close();
        } 
		//catch any file io exception 
		catch (IOException exc)
		{
            //add error log here
            throw exc;
        }
    }

    /**
     * sets current content loaded in memory.
     *
     * @param newContent
     */
    public void setContent(String newContent)
	{
        this.content = newContent;
    }

    /**
     * returns current content loaded in memory.
     *
     * @return
     */
    public String getContent() 
	{
		//outputs loaded file
        return this.content;
    }

    /**
     * clears content to save memory (as they will sometimes be very big files).
     */
    public void clearContent()
	{
        this.content = "";
    }

}
