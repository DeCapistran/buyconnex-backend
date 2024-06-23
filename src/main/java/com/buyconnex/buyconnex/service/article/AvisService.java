package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.AvisMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.repository.article.AvisRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.AvisVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AvisService implements IAvisService{

	@Autowired
	AvisRepository avisRepository;
	
	@Override
	public Optional<AvisVo> findById(Long id) {
		return avisRepository.findById(id).map(AvisMapper::toVO);
	}

	@Override
	public AvisVo saveAvis(AvisVo avisVo) {
		Avis avis = AvisMapper.toEntity(avisVo);
		Avis avisSave = avisRepository.save(avis);
		return AvisMapper.toVO(avisSave);
	}

	@Override
	public void deleteAvis(AvisVo avisVo) {
		Avis avis = AvisMapper.toEntity(avisVo);
		avisRepository.delete(avis);
	}

	@Override
	public AvisVo updateAvis(Long id, AvisVo avisVo) {
		return avisRepository.findById(id).map(avis -> {
			AvisMapper.updateEntityFromVO(avisVo, avis);
			Avis avisUpdated = avisRepository.save(avis);
			return AvisMapper.toVO(avisUpdated);
		}).orElse(null);
	}

	@Override
	public List<AvisVo> findByArticles(ArticlesVo articlesVo) {
		return avisRepository.findByArticles(ArticleMapper.toEntity(articlesVo)).stream().map(AvisMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<AvisVo> findByEtoile(int etoile) {
		return avisRepository.findByEtoile(etoile).stream().map(AvisMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<AvisVo> findByUsers(UsersVo usersVo) {
		return avisRepository.findByUsers(UserMapper.toEntity(usersVo)).stream().map(AvisMapper::toVO).collect(Collectors.toList());
	}

}
