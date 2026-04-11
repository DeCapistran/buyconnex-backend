package com.buyconnex.buyconnex.service.user;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.security.VerificationToken;
import com.buyconnex.buyconnex.entity.user.Roles;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.exception.BadPasswordException;
import com.buyconnex.buyconnex.exception.EmailAlreadyExistsException;
import com.buyconnex.buyconnex.exception.ExpiredTokenException;
import com.buyconnex.buyconnex.exception.InvalidTokenException;
import com.buyconnex.buyconnex.repository.security.VerificationTokenRepository;
import com.buyconnex.buyconnex.entity.user.UserSettings;
import com.buyconnex.buyconnex.repository.user.UserSettingsRepository;
import com.buyconnex.buyconnex.repository.user.RoleRepository;
import com.buyconnex.buyconnex.repository.user.UserRepository;
import com.buyconnex.buyconnex.service.utils.EmailService;
import com.buyconnex.buyconnex.vo.user.NewPasswordVo;
import com.buyconnex.buyconnex.vo.user.RegistrationRequestVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

	private static final String DEFAULT_LANGUE = "fr-FR";

	@Autowired
	UserRepository userRep;
	
	@Autowired
	RoleRepository roleRep;
	
	@Autowired
	UserSettingsRepository userSettingsRep;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	VerificationTokenRepository verificationTokenRepo;
	
	@Autowired
	EmailService emailSender;
	
	@Override
	public Users saveUser(Users user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}

	@Override
	public Users addRoleToUser(String username, String rolename) {
		Users user = userRep.findByUsername(username);
		Roles role = roleRep.findByRole(rolename);
		
		user.getRoles().add(role);
		return user;
	}

	
	@Override
	public Roles addRole(Roles role) {
		return roleRep.save(role);
	}

	@Override
	public Users findUserByUsername(String username) {	
		return userRep.findByUsername(username);
	}
	
	@Override
	public Optional<Users> findUserByEmail(String email) {	
		return userRep.findByEmail(email);
	}

	@Override
	public Users registerUser(RegistrationRequestVo request) {

		Optional<Users>  optionalUser = userRep.findByEmail(request.getEmail());
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email déjà existant!");
		}
		
		Users newUser = new Users();
		newUser.setUsername(request.getEmail());
		//newUser.setDateCreation(LocalDate.now());
		newUser.setFirstname(request.getFirstname());
		newUser.setLastname(request.getLastname());
		newUser.setEmail(request.getEmail());
		
		newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		newUser.setBActivated(false);
		
		userRep.save(newUser);
		
		Roles role = roleRep.findByRole("USER");
		Set<Roles> roles = new HashSet<>();
		roles.add(role);
		newUser.setRoles(roles);
		
		//génére le code secret
		 String code = this.generateCode();

		 VerificationToken token = new VerificationToken(code, newUser);
		 verificationTokenRepo.save(token);
		 
		 //envoyer le code par email à l'utilisateur
		 sendEmailUser(newUser, token.getToken());

		 //créer les paramètres utilisateur par défaut (users_details)
		 UserSettings userSettings = UserSettings.builder()
				 .users(newUser)
				 .langue(DEFAULT_LANGUE)
				 .mfaActive(false)
				 .notifActive(true)
				 .build();
		 userSettingsRep.save(userSettings);

		return userRep.save(newUser);
	}

	private String generateCode() {
		 Random random = new Random();
		 Integer code = 100000 + random.nextInt(900000);

		 return code.toString();

	}
	
	@Override
	public void sendEmailUser(Users u, String code) {
		 String emailBody ="Bonjour "+ "<h1>"+u.getUsername() +"</h1>" +
		 " Votre code de validation est "+"<h1>"+code+"</h1>";
		 
		emailSender.sendEmail(u.getEmail(), emailBody);
		}

	@Override
	public Users validateToken(String code) throws ExpiredTokenException {
		VerificationToken token = verificationTokenRepo.findByToken(code);
		
		if(token == null){
			throw new InvalidTokenException("Invalid Token !!!!!!!");
		}

		Users user = token.getUser();
		
		Calendar calendar = Calendar.getInstance();
		
		if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
			verificationTokenRepo.delete(token);
			throw new ExpiredTokenException("expired Token");
		}
		
		user.setBActivated(true);
		userRep.save(user);
		return user;
	}

	@Override
	public void updatePassword(Users user, NewPasswordVo newPassword) {
		if(!bCryptPasswordEncoder.matches(newPassword.getOldPassword(), user.getPassword())) {
			throw new BadPasswordException("Ancien mot de passe incorrect!");
		}
		user.setPassword(bCryptPasswordEncoder.encode(newPassword.getNewPassword()));
		userRep.save(user);
	}

	@Override
	public VerificationToken findUserByTokenVerificationToken(String token) {
		return verificationTokenRepo.findByToken(token);
	}
}
