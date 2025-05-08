package com.sxpi.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.sxpi.costant.FileDirConstant;
import com.sxpi.service.ZImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Service
@Slf4j
@Transactional
public class ZImageServiceImpl implements ZImageService {

    @Value("${file.banner-dir}")
    private String bannerUrl;

    @Value("${file.head-dir}")
    private String headUrl;

    @Value("${file.result-dir}")
    private String resultUrl;

    @Value("${file.card-dir}")
    private String cardUrl;

    @Value("${file.activity-dir}")
    private String activityUrl;

    @Value("${file.resource-dir}")
    private String resourceUrl;

    @Value("${file.product-dir}")
    private String productUrl;

    @Value("${file.demand-dir}")
    private String demandUrl;
    @Value("${file.enterprise-dir}")
    private String enterpriseUrl;
    @Value("${file.dishes-dir}")
    private String dishesUrl;

    @Override
    public ResponseEntity<byte[]> showFile(String fileName, String imgUri) {
        try {
            Path filePath = null;
            if (Objects.equals(imgUri, FileDirConstant.BANNER)) {
                filePath = Paths.get(bannerUrl).resolve(fileName);
            } else if (Objects.equals(imgUri, FileDirConstant.HEAD)) {
                filePath = Paths.get(headUrl).resolve(fileName);
            } else if (Objects.equals(imgUri, FileDirConstant.RESULT)) {
                filePath = Paths.get(resultUrl).resolve(fileName);
            }else if (Objects.equals(imgUri, FileDirConstant.CARD)) {
                filePath = Paths.get(cardUrl).resolve(fileName);
            }else if (Objects.equals(imgUri, FileDirConstant.ACTIVITY)) {
                filePath = Paths.get(activityUrl).resolve(fileName);
            }else if (Objects.equals(imgUri, FileDirConstant.RESOURCE)) {
                filePath = Paths.get(resourceUrl).resolve(fileName);
            }else if (Objects.equals(imgUri, FileDirConstant.PRODUCT)) {
                filePath = Paths.get(productUrl).resolve(fileName);
            } else if (Objects.equals(imgUri,FileDirConstant.ENTERPRISE)){
                filePath = Paths.get(enterpriseUrl).resolve(fileName);
            }else if (Objects.equals(imgUri,FileDirConstant.DISHES)){
                filePath = Paths.get(dishesUrl).resolve(fileName);
            }

            if (filePath != null && Files.exists(filePath) && Files.isReadable(filePath)) {
                byte[] fileContent = Files.readAllBytes(filePath);
                String contentType = Files.probeContentType(filePath);
                if (contentType == null) {
                    contentType = "application/octet-stream";
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.parseMediaType(contentType));
                return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // TODO 把使用过改方法的方法进行完善
    @Override
    public String uploadImageFile(String path, MultipartFile file, String uuid) {
        // 处理每个文件，与之前相同
        String filename = file.getOriginalFilename();
        log.info("上传文件的名字 = {}", filename);
        String type = FileUtil.extName(filename);

        //定一个文件的唯一标识符
        String fileUUID = uuid + StrUtil.DOT + type;

        //先存储到磁盘
        File uploadParentFile = null;
        File uploadFile = null;
        if (path.equals(FileDirConstant.BANNER)) {
            uploadParentFile = new File(bannerUrl + uuid);
            uploadFile = new File(bannerUrl + fileUUID);
        } /*else if (path.equals(FileDirConstant.GOODS)) {
            uploadParentFile = new File(goodsUrl + uuid);
            uploadFile = new File(goodsUrl + fileUUID);
        }*/ else if (path.equals(FileDirConstant.HEAD)) {
            uploadParentFile = new File(headUrl + uuid);
            uploadFile = new File(headUrl + fileUUID);
        }else if (path.equals(FileDirConstant.CARD)) {
            uploadParentFile = new File(cardUrl + uuid);
            uploadFile = new File(cardUrl + fileUUID);
        }else if (path.equals(FileDirConstant.ACTIVITY)) {
            uploadParentFile = new File(activityUrl + uuid);
            uploadFile = new File(activityUrl + fileUUID);
        }else if (path.equals(FileDirConstant.RESOURCE)) {
            uploadParentFile = new File(resourceUrl + uuid);
            uploadFile = new File(resourceUrl + fileUUID);
        }else if (path.equals(FileDirConstant.PRODUCT)) {
            uploadParentFile = new File(productUrl + uuid);
            uploadFile = new File(productUrl + fileUUID);
        }
        else if (path.equals(FileDirConstant.DEMAND)){
            uploadParentFile = new File(demandUrl + uuid);
            uploadFile = new File(demandUrl + fileUUID);
        }
        else if (path.equals(FileDirConstant.ENTERPRISE)){
            uploadParentFile = new File(enterpriseUrl + uuid);
            uploadFile = new File(enterpriseUrl + fileUUID);
        }
        else if (path.equals(FileDirConstant.DISHES)){
            uploadParentFile = new File(dishesUrl + uuid);
            uploadFile = new File(dishesUrl + fileUUID);
        }
        //判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        if (!uploadParentFile.getParentFile().exists()) {
            uploadParentFile.getParentFile().mkdir();
        }

        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileUUID;
    }

    @Async
    @Override
    public Boolean deleteImageFile(String path, String fileName) {
        Boolean isSuccess = false;
        if (path.equals(FileDirConstant.BANNER)) {
            File file = new File(bannerUrl + fileName);
            log.info("要删除的轮播图文件路径 = {}", file);
            if (file.exists()) {
                isSuccess = file.delete();
            }
        } else if (path.equals(FileDirConstant.RESULT)) {
            File file = new File(resultUrl + fileName);
            log.info("要删除的商品文件路径 = {}", file);
            if (file.exists()) {
                isSuccess = file.delete();
            }
        }
        return isSuccess;
    }

    @Override
    public List<String> batchDeleteFiles(String dir, List<String> fileNames) {
        List<String> failedFiles = new ArrayList<>();
        fileNames.forEach(name -> {
            if (!deleteImageFile(dir, name)) {
                failedFiles.add(name);
            }
        });
        return failedFiles;
    }
}
