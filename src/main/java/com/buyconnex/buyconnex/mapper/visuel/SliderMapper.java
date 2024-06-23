package com.buyconnex.buyconnex.mapper.visuel;

import com.buyconnex.buyconnex.entity.visuel.Sliders;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

public class SliderMapper {

	public static SlidersVo toVO(Sliders sliders) {
		SlidersVo slidersVo = new SlidersVo();
		slidersVo.setImages(sliders.getImages());
		slidersVo.setTitle(sliders.getTittle());
		
		return slidersVo;
	}
	
	public static Sliders toEntity(SlidersVo slidersVo) {
		Sliders sliders = new Sliders();
		sliders.setImages(slidersVo.getImages());
		sliders.setTittle(slidersVo.getTitle());
		
		return sliders;
	}
	
	public static void updateEntityFromVO(SlidersVo slidersVo, Sliders sliders) {
		
		sliders.setImages(slidersVo.getImages());
		sliders.setTittle(slidersVo.getTitle());
	}
}
