package com.asusoftware.uploadFile.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    void upload(MultipartFile file);
}
