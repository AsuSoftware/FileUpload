package com.asusoftware.uploadFile.controller;

import com.asusoftware.uploadFile.model.File;
import com.asusoftware.uploadFile.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/data")
public class FileDataController {

    private final FileService fileService;

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}) // we declare that this controller only consume multipart data
    public void uploadFile(@RequestParam MultipartFile file) throws IOException {
        fileService.uploadFile(file);
    }

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.findAllFile();
    }

    @GetMapping(value = "/{id}")
    public byte[] getFileById(@PathVariable("id")UUID id) throws IOException {
        return fileService.findFileById(id);
    }
}
