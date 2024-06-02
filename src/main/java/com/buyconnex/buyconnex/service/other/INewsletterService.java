package com.buyconnex.buyconnex.service.other;

import java.util.Date;
import java.util.List;

import com.buyconnex.buyconnex.entity.others.Newsletters;
import com.buyconnex.buyconnex.entity.user.Users;

public interface INewsletterService {

	public Newsletters findById(Long id);
	public Newsletters saveNewsletters(Newsletters newsletters);
	public void deleteNewsletters(Newsletters newsletters);
	public Newsletters updateNewsletters(Newsletters newsletters);
	public List<Newsletters> findByDateDesinscription(Date date);
	public List<Newsletters> findByDateInscription(Date date);
	public Newsletters findByEmail(String email);
	public List<Newsletters> findByUsers(Users users);
}
