package ro.societateahermes.backendservice.exceptions;

public class ImageException extends Exception {
    ImageException(Exception e) {
        super(e);
    }


    public ImageException(String message) {
        super(message);
    }
}
