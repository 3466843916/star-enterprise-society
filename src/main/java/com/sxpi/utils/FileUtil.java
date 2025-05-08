package com.sxpi.utils;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author happy
 * @create 2024-01-04-{TIME}
 */
public class FileUtil {
    public static String upload(String uploadPath, MultipartFile file){
        if (!file.isEmpty()) {
            try {
                // 创建存放文件的文件夹，如果不存在则创建
                Path dir = Paths.get(uploadPath);
                if (!Files.exists(dir)) {
                    Files.createDirectories(dir);
                }

                // 获取上传的文件名
                String filename = file.getOriginalFilename();

                // 设置文件存放的路径
                Path path = dir.resolve(filename);

                // 将文件写入到服务器
                Files.write(path, file.getBytes());
                return "File uploaded successfully!";

            } catch (Exception e) {
                e.printStackTrace();
                return "Upload failed!";
            }
        } else {
            return "Upload failed because the file was empty!";
        }
    }
}
