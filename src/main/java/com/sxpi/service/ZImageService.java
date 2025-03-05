package com.sxpi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
public interface ZImageService {
    ResponseEntity<byte[]> showFile(String fileName, String imgUri);

    String uploadImageFile(String path, MultipartFile file, String uuid);
    Boolean deleteImageFile(String path, String fileName);
    List<String> batchDeleteFiles(String dir, List<String> fileNames);
}
