package com.buyconnex.buyconnex.service.utils;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.utils.Files;
import com.buyconnex.buyconnex.repository.utils.FileRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService implements IFileService {

    @NonNull
    private FileRepository fileRepository;

    @Override
    public Files findFileByValueDocId(Long id) {
        return fileRepository.findValueFileByValueId(id);
    }

    @Override
    public void saveFiles(Files files) {
        fileRepository.save(files);
    }

    @Override
    public void deleteFileByValueDocId(Long idValueDoc) {
        fileRepository.deleteFileByOwnerId(idValueDoc);
    }

    @Override
    public Files findFileByOwnerId(Long id) {
        return fileRepository.findFileByOwnerId(id);
    }

    @Override
    public void deleteFileByOwnerId(Long id) {
        fileRepository.deleteFileByOwnerId(id);
    }
}
