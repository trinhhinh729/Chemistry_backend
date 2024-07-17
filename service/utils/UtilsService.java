package com.hcmus.chemistry.service.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.multipart.MultipartFile;

public class UtilsService {

    public static String saveFile(String filePath, MultipartFile file) {
        String fileName =
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) +
            "_" +
            file.getOriginalFilename().replaceAll("[ ;:,/\\\\]", "_");

        File directory = new File(filePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            File convertFile = new File(filePath + "/" + fileName);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteFile(String filePath, String fileName) {
        File file = new File(filePath + "/" + fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
