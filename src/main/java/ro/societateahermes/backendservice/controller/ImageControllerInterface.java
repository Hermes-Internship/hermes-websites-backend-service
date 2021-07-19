package ro.societateahermes.backendservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageControllerInterface {
    void saveImage(MultipartFile multipartFile) throws IOException;

    ResponseEntity<?> getImageByPath(String canonicalImagePath);

    void deleteImage(String canonicalImagePath) throws IOException;

}
