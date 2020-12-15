package com.asusoftware.uploadFile.exception;

public class FileNotFoundException extends FileException{
    public FileNotFoundException() {
        super("File not found");
    }
}
