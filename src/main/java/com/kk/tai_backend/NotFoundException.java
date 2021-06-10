package com.kk.tai_backend;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Entity not found!");
    }
}
