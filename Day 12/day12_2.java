//Write a program to create a new folder, rename and delete it.  
import java.io.File;

public class day12_2{ // FileOperations

    public static void createFolder(String folderName) {
        File folder = new File(folderName);
        if (folder.mkdir()) {
            System.out.println("Folder created successfully!");
        } else {
            System.out.println("Folder creation failed.");
        }
    }

    public static void renameFolder(String oldName, String newName) {
        File oldFolder = new File(oldName);
        File newFolder = new File(newName);
        if (oldFolder.renameTo(newFolder)) {
            System.out.println("Folder renamed successfully!");
        } else {
            System.out.println("Folder renaming failed.");
        }
    }

    public static void deleteFolder(String folderName) {
        File folder = new File(folderName);
        if (folder.delete()) {
            System.out.println("Folder deleted successfully!");
        } else {
            System.out.println("Folder deletion failed.");
        }
    }

    public static void main(String[] args) {
        // Creating a folder
        createFolder("testFolder");

        // Renaming the folder
        renameFolder("testFolder", "renamedFolder");

        // Deleting the folder
        deleteFolder("renamedFolder");
    }
}
