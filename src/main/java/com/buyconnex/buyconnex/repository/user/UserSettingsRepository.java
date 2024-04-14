package com.buyconnex.buyconnex.repository.user;

import com.buyconnex.buyconnex.entity.user.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserSettingsRepository extends JpaRepository<UserSettings, Long> {

    @Query("SELECT s FROM UserSettings s WHERE s.users.username =:login")
    public UserSettings getUserSettingByLogin(String login);

    @Query("SELECT s FROM UserSettings s WHERE s.users.id =:id")
    public UserSettings getUserSettingByUserId(Long id);

    @Query("SELECT s FROM UserSettings s WHERE s.users.email =:email")
    public UserSettings getUserSettingByEmail(String email);
}
