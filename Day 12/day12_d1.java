//Write a program to list all the files or directories available in given directory.  
import java.io.File;

public class ListFilesInDirectory {

    public static void listFiles(String directoryName) {
        File directory = new File(directoryName);

        // Check if the directory exists and is indeed a directory
        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list(); // Get the list of files and directories
            if (files != null && files.length > 0) {
                System.out.println("Files in " + directoryName + ":");
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println(directoryName + " is not a valid directory.");
        }
    }

    public static void main(String[] args) {
        // List files in the current directory
        listFiles(".");
    }
}
