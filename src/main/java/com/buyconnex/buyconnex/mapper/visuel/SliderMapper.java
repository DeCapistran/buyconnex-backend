package com.buyconnex.buyconnex.mapper.visuel;

import com.buyconnex.buyconnex.entity.visuel.Sliders;
import com.buyconnex.buyconnex.mapper.article.ImageMapper;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

public class SliderMapper {

	public static SlidersVo toVO(Sliders sliders) {
		SlidersVo slidersVo = new SlidersVo();
		slidersVo.setImages(ImageMapper.toVO(sliders.getImages()));
		slidersVo.setTitle(sliders.getTittle());
		
		return slidersVo;
	}
	
	public static Sliders toEntity(SlidersVo slidersVo) {
		Sliders sliders = new Sliders();
		sliders.setImages(ImageMapper.toEntity(slidersVo.getImages()));
		sliders.setTittle(slidersVo.getTitle());
		
		return sliders;
	}
	
	public static void updateEntityFromVO(SlidersVo slidersVo, Sliders sliders) {
		
		sliders.setImages(ImageMapper.toEntity(slidersVo.getImages()));
		sliders.setTittle(slidersVo.getTitle());
	}
}
