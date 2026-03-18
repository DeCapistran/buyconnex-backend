package com.buyconnex.buyconnex.repository.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.buyconnex.buyconnex.entity.utils.Settings;

public interface SettingRepository extends JpaRepository<Settings, Long> {

    @Query("SELECT s FROM Settings s WHERE s.id =:id")
    public Settings getSettingById(Long id);
}
