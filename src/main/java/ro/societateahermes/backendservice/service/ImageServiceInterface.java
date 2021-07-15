package ro.societateahermes.backendservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageServiceInterface {
    void convertMultiPartToFile(MultipartFile file) throws IOException;
}
