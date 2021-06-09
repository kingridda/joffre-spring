package com.joffre.joffrespring.services;

import com.joffre.joffrespring.storage.StorageException;
import com.joffre.joffrespring.storage.StorageFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

//Service implementation inside storage package
public interface StorageService {

    void init() throws StorageException;

    void store(MultipartFile file, String storingName) throws StorageException;

    Stream<Path> loadAll()  throws StorageException;

    Path load(String filename) throws StorageException;

    Resource loadAsResource(String filename) throws StorageFileNotFoundException;

    void deleteAll();

}