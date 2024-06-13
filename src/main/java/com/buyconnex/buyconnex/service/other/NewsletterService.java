package com.buyconnex.buyconnex.service.other;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.others.Newsletters;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.others.NewsletterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NewsletterService implements INewsletterService {

	@Autowired
	NewsletterRepository newsletterRepository;
	
	@Override
	public Optional<Newsletters> findById(Long id) {
		return newsletterRepository.findById(id);
	}

	@Override
	public Newsletters saveNewsletters(Newsletters newsletters) {
		return newsletterRepository.save(newsletters);
	}

	@Override
	public void deleteNewsletters(Newsletters newsletters) {
		newsletterRepository.delete(newsletters);
	}

	@Override
	public Newsletters updateNewsletters(Newsletters newsletters) {
		return newsletterRepository.save(newsletters);
	}

	@Override
	public List<Newsletters> findByDateDesinscription(Date date) {
		return newsletterRepository.findByDateDesinscription(date);
	}

	@Override
	public List<Newsletters> findByDateInscription(Date date) {
		return newsletterRepository.findByDateInscription(date);
	}

	@Override
	public Newsletters findByEmail(String email) {
		return newsletterRepository.findByEmail(email);
	}

	@Override
	public List<Newsletters> findByUsers(Users users) {
		return newsletterRepository.findByUsers(users);
	}

}
