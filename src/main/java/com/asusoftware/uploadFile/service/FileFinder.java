package com.asusoftware.uploadFile.service;

import com.asusoftware.uploadFile.model.File;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface FileFinder {
    List<File> findAllFiles();
    byte[] findFileById(UUID id) throws IOException;
}
