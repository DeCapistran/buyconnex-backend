package com.buyconnex.buyconnex.service.visuel;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

public interface ISliderService {

	public Optional<SlidersVo> findById(Long id);
	public List<SlidersVo> findAll();
	public SlidersVo saveSliders(SlidersVo slidersVo);
	public void deleteSliders(SlidersVo slidersVo);
	public void deleteSlidersById(Long id);
	public SlidersVo updateSliders(Long id, SlidersVo slidersVo);
	public Optional<SlidersVo> findByImage(ImagesVo imagesVo);
	public Optional<SlidersVo> findByTittle(String tittle);
}
