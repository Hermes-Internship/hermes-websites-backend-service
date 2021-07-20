package ro.societateahermes.backendservice.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    private static final String RESOURCES_PATH = "src/main/resources/";

    public static void saveFileToResources(byte[] content, String newFolderName, String imageName) {
        newFolderName = newFolderName.charAt(0) != '/' ? "/" + newFolderName : newFolderName;
        newFolderName = newFolderName.charAt(newFolderName.length() - 1) != '/' ? newFolderName + "/" : newFolderName;

        Path filePath = Paths.get(RESOURCES_PATH + newFolderName + imageName);
        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filePath) {
        Path filePath1 = Paths.get(filePath);
        try {
            Files.delete(filePath1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
