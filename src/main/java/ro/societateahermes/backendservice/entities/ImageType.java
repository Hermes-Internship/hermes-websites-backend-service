package ro.societateahermes.backendservice.entities;

public enum ImageType {
    CD("cd");

    private String folderName;

    ImageType(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName() {
        return folderName;
    }
}
