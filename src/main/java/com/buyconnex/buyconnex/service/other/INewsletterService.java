package com.buyconnex.buyconnex.service.other;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.other.NewslettersVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

public interface INewsletterService {

	public Optional<NewslettersVo> findById(Long id);
	public List<NewslettersVo> findAll();
	public NewslettersVo saveNewsletters(NewslettersVo newslettersVo);
	public void deleteNewsletters(NewslettersVo newslettersVo);
	public void deleteNewslettersById(Long id);
	public NewslettersVo updateNewsletters(Long id, NewslettersVo newslettersVo);
	public List<NewslettersVo> findByDateDesinscription(Date date);
	public List<NewslettersVo> findByDateInscription(Date date);
	public Optional<NewslettersVo> findByEmail(String email);
	public List<NewslettersVo> findByUsers(UsersVo usersVo);
}
