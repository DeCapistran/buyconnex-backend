package com.buyconnex.buyconnex.service.visuel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.visuel.Footers;
import com.buyconnex.buyconnex.mapper.visuel.FooterMapper;
import com.buyconnex.buyconnex.repository.visuel.FootersRepository;
import com.buyconnex.buyconnex.vo.visuel.FootersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FooterService implements IFooterService{
	
	@Autowired
	FootersRepository footersRepository;

	@Override
	public Optional<FootersVo> findById(Long id) {
		return footersRepository.findById(id).map(FooterMapper::toVO);
	}

	@Override
	public List<FootersVo> findAll() {
		return footersRepository.findAll().stream().map(FooterMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public FootersVo saveFooters(FootersVo footersVo) {
		Footers footers = FooterMapper.toEntity(footersVo);
		Footers footersSave = footersRepository.save(footers);
		return FooterMapper.toVO(footersSave);
	}

	@Override
	public void deleteFooters(FootersVo footersVo) {
		Footers footers = FooterMapper.toEntity(footersVo);
		footersRepository.delete(footers);
	}

	@Override
	public void deleteFootersById(Long id) {
		footersRepository.deleteById(id);
	}

	@Override
	public FootersVo updateFooters(Long id, FootersVo footersVo) {
		return footersRepository.findById(id).map(footer -> {
			FooterMapper.updateEntityFromVO(footersVo, footer);
			Footers footersupdated = footersRepository.save(footer);
			return FooterMapper.toVO(footersupdated);
		}).orElse(null);
	}

	@Override
	public Optional<FootersVo> findByAdresse(String adresse) {
		return footersRepository.findByAdresse(adresse).map(FooterMapper::toVO);
	}

	@Override
	public Optional<FootersVo> findByMailSupport(String mail) {
		return footersRepository.findByAdresse(mail).map(FooterMapper::toVO);
	}

	@Override
	public Optional<FootersVo> findByTelephone(String telephone) {
		return footersRepository.findByAdresse(telephone).map(FooterMapper::toVO);
	}

}
