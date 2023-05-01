package com.zero314.evaluatemanage.controller;

import com.zero314.evaluatemanage.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author yh
 */
@RestController
public class ResourceController {
    @Value("${file.path}")
    private String imgPath;

    /**
     * 上传文件
     *
     * @param file 文件
     * @return String
     */
    @PostMapping("/upload")
    public Result uploadImg(@RequestParam("file") MultipartFile file) {

        // 获取文件后缀名
        String fileName = file.getOriginalFilename();
        Assert.isTrue(fileName != null, "文件名为空");
        String stffixName = fileName.substring(fileName.lastIndexOf("."));

        // 重命名文件
        UUID uuid = UUID.randomUUID();
        String finalName = uuid + stffixName;
        // 当文件名重复 可能性极小
        while (new File(finalName).exists()) {
            uuid = UUID.randomUUID();
            finalName = uuid + stffixName;
        }

        // 文件保存
        String finalPath = imgPath + File.separator + finalName;
        try {
            file.transferTo(new File(finalPath));
        } catch (Exception e) {
            return Result.error("上传失败");
        }
        return Result.data("/public/" + finalName);
    }
}

