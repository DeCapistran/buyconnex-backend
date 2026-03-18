package com.buyconnex.buyconnex.service.utils;

import com.buyconnex.buyconnex.entity.utils.Files;

public interface IFileService {

    public Files findFileByValueDocId(Long id);

    public void saveFiles(Files files);

    public void deleteFileByValueDocId(Long idValueDoc);

    public Files findFileByOwnerId(Long id);

    public void deleteFileByOwnerId(Long id);

}
