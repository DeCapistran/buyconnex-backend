package com.buyconnex.buyconnex.service.other;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.others.Newsletters;
import com.buyconnex.buyconnex.mapper.other.NewsletterMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.repository.others.NewsletterRepository;
import com.buyconnex.buyconnex.vo.other.NewslettersVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NewsletterService implements INewsletterService {

	@Autowired
	NewsletterRepository newsletterRepository;
	
	@Override
	public Optional<NewslettersVo> findById(Long id) {
		return newsletterRepository.findById(id).map(NewsletterMapper::toVO);
	}

	@Override
	public NewslettersVo saveNewsletters(NewslettersVo newslettersVo) {
		Newsletters newsletters = NewsletterMapper.toEntity(newslettersVo);
		Newsletters newslettersSave = newsletterRepository.save(newsletters);
		return NewsletterMapper.toVO(newslettersSave);
	}

	@Override
	public void deleteNewsletters(NewslettersVo newslettersVo) {
		Newsletters newsletters = NewsletterMapper.toEntity(newslettersVo);
		newsletterRepository.delete(newsletters);
	}

	@Override
	public NewslettersVo updateNewsletters(Long id, NewslettersVo newslettersVo) {
		return newsletterRepository.findById(id).map(newsletter -> {
			NewsletterMapper.updateEntityFromVO(newslettersVo, newsletter);
			Newsletters newslettersUpdated = newsletterRepository.save(newsletter);
			return NewsletterMapper.toVO(newslettersUpdated);
		}).orElse(null);
	}

	@Override
	public List<NewslettersVo> findByDateDesinscription(Date date) {
		return newsletterRepository.findByDateDesinscription(date).stream().map(NewsletterMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<NewslettersVo> findByDateInscription(Date date) {
		return newsletterRepository.findByDateInscription(date).stream().map(NewsletterMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public Optional<NewslettersVo> findByEmail(String email) {
		return newsletterRepository.findByEmail(email).map(NewsletterMapper::toVO);
	}

	@Override
	public List<NewslettersVo> findByUsers(UsersVo usersVo) {
		return newsletterRepository.findByUsers(UserMapper.toEntity(usersVo)).stream().map(NewsletterMapper::toVO).collect(Collectors.toList());
	}

}
