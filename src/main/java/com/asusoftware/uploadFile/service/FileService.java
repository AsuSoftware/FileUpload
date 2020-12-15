package com.asusoftware.uploadFile.service;

import com.asusoftware.uploadFile.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface FileService {
    void uploadFile(MultipartFile file) throws IOException;
    byte[] findFileById(UUID id) throws IOException;
    List<File> findAllFile();
}
