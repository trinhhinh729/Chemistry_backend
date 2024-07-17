package com.hcmus.chemistry.service;

import com.hcmus.chemistry.service.dto.ImageResponse;
import com.hcmus.chemistry.service.utils.UtilsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    private final Logger log = LoggerFactory.getLogger(ImageService.class);

    public ImageResponse uploadImage(MultipartFile image) {
        log.debug("Request to upload image : {}", image);
        return new ImageResponse(StringUtils.join("/api/public-images/", UtilsService.saveFile("upload", image)));
    }

    public void deleteImage(String fileName) {
        log.debug("Request to delete image : {}", fileName);
        UtilsService.deleteFile("upload", fileName);
    }
}
