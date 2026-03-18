package com.buyconnex.buyconnex.service.visuel;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.visuel.FootersVo;

public interface IFooterService {

	public Optional<FootersVo> findById(Long id);
	public List<FootersVo> findAll();
	public FootersVo saveFooters(FootersVo footersVo);
	public void deleteFooters(FootersVo footersVo);
	public void deleteFootersById(Long id);
	public FootersVo updateFooters(Long id, FootersVo footersVo);
	public Optional<FootersVo> findByAdresse(String adresse);
	public Optional<FootersVo> findByMailSupport(String mail);
	public Optional<FootersVo> findByTelephone(String telephone);
}
