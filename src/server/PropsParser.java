package server;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropsParser
{
    // The "names" found in the db.props file
    // Remember the file follows the following structure:
    // name = value
    // This is inspired from the structure of an INI file
    enum Name
    {
        URL,
        Database,
        Username,
        Password,
    }

    // The location of the props file in the filesystem
    private String fileLocation;

    // Data found in db.props file
    private String URL, Database, Username, Password;

    // The regular expression used to extract data from the props file
    // This will typically be what a key looks like and will select
    // the value only
    // Example:
    // jcbd.url = 127.0.0.1
    // the ip address is the value that we want to extract and so
    // will be targeted using the regular expression
    private static final Pattern dataPattern = Pattern.compile("[a-z]+.[a-z]+[ ]*=[ ]*([\\S]+)");

    /***
     *
     * @param fileLocation The location of the props file to be parsed
     * @throws IOException If the file is not accessible due to insufficient user privileges, the file does not exist, insufficient RAM, etc...
     */
    PropsParser(String fileLocation) throws IOException
    {
        this.fileLocation = fileLocation;

        try
        {
            ExtractData();
        }
        catch(Exception e)
        {
            throw e;
        }
    }


    /*****
     * Retrieves the data from the props file
     * @throws IOException
     */
    private void ExtractData() throws IOException
    {
        try
        {
            // Attempt to open the file and extract data
            List<String> propsFile = Files.readAllLines(Paths.get(this.fileLocation));

            // Loop through all the lines and extract the data
            for(String line : propsFile)
            {
                // Skip comments
                if(line.charAt(0) == '#')
                    continue;

                //dataPattern.matcher(line).toString()

            }
        }
        catch(IOException e)
        {
            throw e;
        }
    }

    /*****
     *
     * @param name the name of the key
     * @return the value of the name
     */
    public String GetValue(Name name)
    {
        switch(name)
        {
            case URL: return URL;
            case Database: return Database;
            case Username: return Username;
            case Password: return Password;
            default: throw new InvalidParameterException();
        }
    }


}
