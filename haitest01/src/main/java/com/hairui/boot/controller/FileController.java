package com.hairui.boot.controller;

import com.hairui.boot.entity.Result;
import com.hairui.boot.util.FastDFSClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Api(tags = "照片上传接口")
@Slf4j
@RequestMapping("//file")
public class FileController {
    @Autowired
    FastDFSClientUtil fastDFSClientUtil;
    @ApiOperation(value = "用于照片上传",
            notes = "<span style='color:red'>描述：</span>&nbsp;&nbsp;用来上传照片,接口：http://120.78.238.34:8080/file/getUrl")
    @PostMapping("/getUrl")
    public Result getUrl(@RequestParam("file") MultipartFile photo) throws IOException {
        if (!photo.isEmpty()) {
            log.info(fastDFSClientUtil.uploadFile(photo));
            return Result.builder().status(200).msg("上传文件成功").data(fastDFSClientUtil.uploadFile(photo)).build();
        }
        return Result.builder().status(500).msg("上传文件失败").build();
    }
}
