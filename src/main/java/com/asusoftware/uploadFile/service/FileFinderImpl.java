package com.asusoftware.uploadFile.service;

import com.asusoftware.uploadFile.exception.FileNotFoundException;
import com.asusoftware.uploadFile.model.File;
import com.asusoftware.uploadFile.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileFinderImpl implements FileFinder {

    private final FileRepository fileRepository;

    @Override
    public List<File> findAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    public byte[] findFileById(UUID id) throws IOException {
        File fileData = fileRepository.findById(id).orElseThrow(FileNotFoundException::new);
        String path = fileData.getPath();
        return Files.readAllBytes(Paths.get(path));
    }
}
