package com.buyconnex.buyconnex.repository.utils;

import com.buyconnex.buyconnex.entity.utils.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FileRepository extends JpaRepository<Files, Long> {

    @Modifying
    @Query("DELETE FROM Files file WHERE file.owner1Id =:idValueDoc")
    public void deleteFileByOwnerId(Long idValueDoc);

    @Query("SELECT file FROM Files file WHERE file.owner1Id =:idValueDoc")
    public Files findValueFileByValueId(Long idValueDoc);

    @Query("SELECT file FROM Files file WHERE file.owner1Id =:idValueDoc")
    public Files findFileByOwnerId(Long idValueDoc);

}
