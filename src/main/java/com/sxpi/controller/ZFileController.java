package com.sxpi.controller;

import com.sxpi.service.ZImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@RestController
@RequestMapping("/img")
public class ZFileController {
    @Autowired
    private ZImageService imageService;

    /**
     * 查看图片
     * @param fileName 文件名字
     * @param imgUri 和下面的path参数一样
     */
    @GetMapping("/{imgUri}/{fileName}")
    public ResponseEntity<byte[]> getFile(@PathVariable(value = "fileName") String fileName, @PathVariable(value = "imgUri") String imgUri) {
        return imageService.showFile(fileName, imgUri);
    }
}
