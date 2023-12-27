package com.buyconnex.buyconnex.repository.utils;

import com.buyconnex.buyconnex.entity.utils.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<Files, Long> {

    @Modifying
    @Query("DELETE FROM Files WHERE file.ownerId =:idValueDoc")
    public void deleteFileByOwnerId(Long idValueDoc);

    @Query("SELECT file FROM Files file WHERE file.ownerId =:idValueDoc")
    public Files findValueFileByValueId(Long idValueDoc);

    @Query("SELECT file FROM Files file WHERE file.ownerId =:idValueDoc")
    public Files findFileByOwnerId(Long idValueDoc);

}
