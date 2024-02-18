package com.buyconnex.buyconnex.controller.account;
import com.buyconnex.buyconnex.service.user.UserService;
import com.buyconnex.buyconnex.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {

	private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody NewPasswordVo request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
}
