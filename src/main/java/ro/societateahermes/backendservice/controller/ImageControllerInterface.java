package ro.societateahermes.backendservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ImageControllerInterface {
    String saveImage(MultipartFile multipartFile) throws IOException;

    ResponseEntity<?> getImageByPath(String canonicalImagePath) throws URISyntaxException, IOException;

    void deleteImage(String canonicalImagePath) throws IOException, URISyntaxException;

}