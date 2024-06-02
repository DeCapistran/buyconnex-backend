package com.buyconnex.buyconnex.repository.visuel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.visuel.Sliders;


public interface SlidersRepository extends JpaRepository<Sliders, Long> {

	List<Sliders> findByImages(Images images);
	Sliders findByTittle(String tittle);
}
