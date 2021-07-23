package ro.societateahermes.backendservice.controller.controllerImplementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.societateahermes.backendservice.controller.ImageControllerInterface;
import ro.societateahermes.backendservice.entities.ImageType;
import ro.societateahermes.backendservice.service.serviceImplementation.ImageServiceImplementation;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;


@RestController
@RequestMapping("/images")
public class ImageControllerImplementation implements ImageControllerInterface {

    private final ImageServiceImplementation imageService;

    public ImageControllerImplementation(ImageServiceImplementation imageService) {
        this.imageService = imageService;
    }

    @Override
    @PostMapping("/cd")
    public String saveImage(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return imageService.convertMultiPartToFile(multipartFile, ImageType.CD);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE, value = "/cd")
    public ResponseEntity<?> getImageByPath(@RequestParam("name") String imageName) throws URISyntaxException, IOException {
        File image = imageService.getImageByPath(imageName, ImageType.CD);
        byte[] imageContent = Files.readAllBytes(image.toPath());
        return new ResponseEntity<>(imageContent, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/cd")
    public void deleteImage(@RequestParam("name") String imageName) throws IOException, URISyntaxException {
        imageService.deleteImage(imageName, ImageType.CD);
    }
}
