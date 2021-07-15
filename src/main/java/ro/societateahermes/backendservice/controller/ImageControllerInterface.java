package ro.societateahermes.backendservice.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageControllerInterface {
    void savePhoto(MultipartFile multipartFile) throws IOException;
}
