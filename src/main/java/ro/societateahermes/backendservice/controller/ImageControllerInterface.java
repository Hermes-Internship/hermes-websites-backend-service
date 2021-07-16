package ro.societateahermes.backendservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.entities.Image;

import java.io.IOException;
import java.util.List;

public interface ImageControllerInterface {
    void savePhoto(MultipartFile multipartFile) throws IOException;

    ResponseEntity<?> getImageByPath(String canonicalImagePath);

    List<Image> getAll();

}
