package com.buyconnex.buyconnex.service.visuel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.visuel.Sliders;
import com.buyconnex.buyconnex.mapper.article.ImageMapper;
import com.buyconnex.buyconnex.mapper.visuel.SliderMapper;
import com.buyconnex.buyconnex.repository.visuel.SlidersRepository;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SliderService implements ISliderService {

	SlidersRepository slidersRepository;
	
	@Override
	public Optional<SlidersVo> findById(Long id) {
		return slidersRepository.findById(id).map(SliderMapper::toVO);
	}

	@Override
	public List<SlidersVo> findAll() {
		return slidersRepository.findAll().stream().map(SliderMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public SlidersVo saveSliders(SlidersVo slidersVo) {
		Sliders sliders = SliderMapper.toEntity(slidersVo);
		Sliders slidersSave = slidersRepository.save(sliders);
		return SliderMapper.toVO(slidersSave);
	}

	@Override
	public void deleteSliders(SlidersVo slidersVo) {
		Sliders sliders = SliderMapper.toEntity(slidersVo);
		slidersRepository.delete(sliders);
	}

	@Override
	public void deleteSlidersById(Long id) {
		slidersRepository.deleteById(id);
	}

	@Override
	public SlidersVo updateSliders(Long id, SlidersVo slidersVo) {
		return slidersRepository.findById(id).map(slider -> {
			SliderMapper.updateEntityFromVO(slidersVo, slider);
			Sliders slidersUpdated = slidersRepository.save(slider);
			return SliderMapper.toVO(slidersUpdated);
		}).orElse(null);
	}

	@Override
	public Optional<SlidersVo> findByImage(ImagesVo imagesVo) {
		return slidersRepository.findByImages(ImageMapper.toEntity(imagesVo)).map(SliderMapper::toVO);
	}

	@Override
	public Optional<SlidersVo> findByTittle(String tittle) {
		return slidersRepository.findByTittle(tittle).map(SliderMapper::toVO);
	}

}
