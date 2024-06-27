package com.buyconnex.buyconnex.repository.others;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.others.Newsletters;
import com.buyconnex.buyconnex.entity.user.Users;



public interface NewsletterRepository extends JpaRepository<Newsletters, Long> {

	List<Newsletters> findByDateInscription(Date dateInscription);
	List<Newsletters> findByDateDesinscription(Date dateDesinscription);
	Optional<Newsletters> findByEmail(String email);
	List<Newsletters> findByUsers(Users users);
	//boolean existByEmail(String email);
}
