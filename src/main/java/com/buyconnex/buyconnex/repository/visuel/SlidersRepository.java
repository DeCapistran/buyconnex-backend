package com.buyconnex.buyconnex.repository.visuel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.visuel.Sliders;


public interface SlidersRepository extends JpaRepository<Sliders, Long> {

	Optional<Sliders> findByImages(Images images);
	Optional<Sliders> findByTittle(String tittle);
}
