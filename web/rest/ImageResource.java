package com.hcmus.chemistry.web.rest;

import com.hcmus.chemistry.service.ImageService;
import com.hcmus.chemistry.service.dto.ImageResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.jhipster.config.JHipsterProperties;

@RestController
@RequestMapping("/api")
public class ImageResource {

    private final Logger log = LoggerFactory.getLogger(ImageResource.class);

    private final JHipsterProperties jHipsterProperties;

    private final ImageService imageService;

    public ImageResource(JHipsterProperties jHipsterProperties, ImageService imageService) {
        this.jHipsterProperties = jHipsterProperties;
        this.imageService = imageService;
    }

    @GetMapping(value = "/public-images/{fileName:.+}")
    public ResponseEntity<byte[]> getPublicImage(@PathVariable String fileName) throws IOException {
        File file = new File("upload" + File.separator + fileName);
        Path path = Paths.get(file.getAbsolutePath());
        if (file.exists()) {
            long cacheTimeToLive = TimeUnit.DAYS.toMillis(jHipsterProperties.getHttp().getCache().getTimeToLiveInDays());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(getImageMediaType(Files.probeContentType(path)));
            headers.setCacheControl("max-age=" + cacheTimeToLive + ", public");
            headers.setPragma("cache");
            headers.setExpires(cacheTimeToLive + System.currentTimeMillis());
            return ResponseEntity.ok().headers(headers).body(Files.readAllBytes(path));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/images/upload-image")
    public ResponseEntity<ImageResponse> uploadImage(@RequestParam("file") MultipartFile file) {
        log.debug("REST request to upload image : {}", file);
        return ResponseEntity.ok().body(imageService.uploadImage(file));
    }

    @DeleteMapping("/public-images/{fileName:.+}")
    public ResponseEntity<Void> deleteImage(@PathVariable String fileName) {
        log.debug("REST request to delete image : {}", fileName);
        imageService.deleteImage(fileName);
        return ResponseEntity.noContent().build();
    }

    private MediaType getImageMediaType(String contentType) {
        if (StringUtils.equals(contentType, "image/svg+xml")) {
            return new MediaType("image", "svg+xml");
        } else if (StringUtils.equals(contentType, "image/png")) {
            return MediaType.IMAGE_PNG;
        } else if (StringUtils.equals(contentType, "image/jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else {
            // Handle unsupported image types or return a default media type
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
