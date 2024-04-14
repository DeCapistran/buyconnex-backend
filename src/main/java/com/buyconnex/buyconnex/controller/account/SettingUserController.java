package com.buyconnex.buyconnex.controller.account;

import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.controller.DefaultRestController;
import com.buyconnex.buyconnex.entity.user.UserSettings;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.service.user.IUserSettingService;
import com.buyconnex.buyconnex.vo.GenericResponseVo;
import com.buyconnex.buyconnex.vo.UserSettingVo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SettingUserController extends DefaultRestController{

	public static final Logger logger = LoggerFactory.getLogger(SettingUserController.class);
	
	@NonNull
	private IUserSettingService userSettingService;
	
	@PostMapping("/user-settings")
	public ResponseEntity<UserSettingVo> getUserSettings(Principal principal) {
		UserSettingVo userSettingVo = new UserSettingVo();
		Optional<Users> user = getUser(principal);
		if(user.isPresent()) {
			UserSettings userSettings = userSettingService.getUserSettingByUserId(user.get().getUser_id());
			if(userSettings != null) {
				userSettingVo.setLangue(userSettings.getLangue());
				userSettingVo.setMfaActive(userSettings.isMfaActive());
				userSettingVo.setNotifActive(userSettings.isNotifActive());
				return ResponseEntity.ok(userSettingVo);
			}
			userSettingVo.setDefaultLangue();
		}
		return new ResponseEntity<>(userSettingVo, org.springframework.http.HttpStatus.OK);
		
	}
	
	@PostMapping("/update-setting")
	public GenericResponseVo updateSetting(Principal principal, @RequestBody UserSettingVo userSettingVo) {
		Optional<Users> user = getUser(principal);
		if(user.isPresent() && userSettingVo != null) {
			UserSettings userSettings = userSettingService.getUserSettingByUserId(user.get().getUser_id());
			if(userSettings == null) {
				userSettings = new UserSettings();
				userSettings.setUsers(user.get());
			}
			userSettings.setLangue(userSettingVo.getLangue());
			userSettings.setNotifActive(userSettingVo.isNotifActive());
			userSettings.setMfaActive(userSettingVo.isMfaActive());
			userSettingService.saveUserSettings(userSettings);
			return new GenericResponseVo(messages.getMessage("message.setting.update", null, LocaleContextHolder.getLocale()), org.apache.http.HttpStatus.SC_OK);
		}
		return new GenericResponseVo(messages.getMessage("message.setting.update.error", null, LocaleContextHolder.getLocale()), org.apache.http.HttpStatus.SC_BAD_REQUEST);
	}
}
