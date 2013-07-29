/*  Sachith Dassanayake
 *  BBK_COIY029H7_2011: Component Based Software Development
 *  Submission Date 04/03/2012
 */
package operations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sachith Dassanayake
 * A class for handle file operations mainly reading, writing and searching functions
 */
public class MyFileHandler {

    
    /**
     * This method writes a string array to a file line by line
     * @param textToWrite A String array to write on a file. Each element of the array is considered as one line of the text file 
     * @param filename File name including the full path name
     * @return A boolean value True if file write is successful or False if it fails
     */
    
    public boolean writeFile(String[] textToWrite, String filename) {

        boolean results = false;
        PrintWriter out = null;
        try {
            FileWriter outFile = new FileWriter(filename, true);
            out = new PrintWriter(outFile);

            for (String s : textToWrite) {
                out.println(s);
            }

            out.close();
            results = true;
        } catch (IOException e) {
            results = false;
        } finally {
            try {
                out.close();
            } catch (Exception e) {

            }
        }

        return results;
    }

    
    /**
     * This method reads a given text file and returns every line of the file in a String array
     * @param filename File name including the full path name
     * @return A String array. Each element of the array consists of one line of the given file
     */
    
    
    public String[] readFile(String filename) {

        File file = new File(filename);
        BufferedReader br = null;

        List<String> list = new ArrayList<String>();


        try {
            br = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(file)));
            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }


        } catch (Exception e) {
        } finally {
            try {
                br.close();

            } catch (Exception e) {
                /*
                 * ignore
                 */
            }
        }


        String[] fileContent = list.toArray(new String[0]);
        return fileContent;
    }
    
    /**
     * This method search a file for a specific string and returns a boolean value
     * @param searchString String value to look for in a given file
     * @param filename File name including the full path name
     * @return A boolean value True if the text is found and False if not found
     */

    public int searchFile(String searchString, String filename) {
        int result = 0;
        Scanner in = null;
        boolean found = false;
        try {
            in = new Scanner(new FileReader(filename));
            while (in.hasNextLine() && !found) {
                found = in.nextLine().indexOf(searchString) >= 0;
            }
            if (found) {
                result = 1; //SSN Found
            }
        } catch (Exception e) {
           // e.printStackTrace();
            
            //File not found so create a new empty file
            result = 3;
            File file = new File(filename);
            
            try {
                file.createNewFile();
            } catch (IOException ex) {
                //Logger.getLogger(MyFileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                in.close();
            } catch (Exception e) {

            }
        }
        return result;
    }
}
