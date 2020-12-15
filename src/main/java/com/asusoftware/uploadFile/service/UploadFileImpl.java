package com.asusoftware.uploadFile.service;

import com.asusoftware.uploadFile.model.File;
import com.asusoftware.uploadFile.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


@Service
@RequiredArgsConstructor
public class UploadFileImpl implements UploadFile{

    private final FileRepository fileRepository;

    @Override
    public void upload(MultipartFile file) {
            try {
                String path = "src/main/resources/data/" + file.getOriginalFilename() + ".txt";
                Path path1 = Paths.get(path);
                Files.write(path1, file.getBytes());
                fileRepository.save(createFileEntity(path));
            } catch (IOException ex) {
                System.out.println("Pb " + ex.getMessage());
            }
    }

    private File createFileEntity(String path) {
        File data = new File();
        data.setPath(path);
        return data;
    }
}
