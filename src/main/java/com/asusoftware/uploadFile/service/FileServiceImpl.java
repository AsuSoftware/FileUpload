package com.asusoftware.uploadFile.service;

import com.asusoftware.uploadFile.model.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    private final UploadFile uploadFile;
    private final FileFinder fileFinder;

    @Override
    public void uploadFile(MultipartFile file) {
        uploadFile.upload(file);
    }

    @Override
    public byte[] findFileById(UUID id) throws IOException {
        return fileFinder.findFileById(id);
    }

    @Override
    public List<File> findAllFile() {
        return fileFinder.findAllFiles();
    }
}
