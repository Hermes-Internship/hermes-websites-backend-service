package ro.societateahermes.backendservice.repository;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class FileSystemRepository {
    private final String RESOURCES_DIR = "src/main/resources/";

    public void saveFile(byte[] content, String folderName, String imageName) {
        folderName = folderName.charAt(0) != '/' ? "/" + folderName : folderName;
        folderName = folderName.charAt(folderName.length() - 1) != '/' ? folderName + "/" : folderName;

        Path newFile = Paths.get(RESOURCES_DIR + folderName + imageName);
        try {
            Files.createDirectories(newFile.getParent());
            Files.write(newFile, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
