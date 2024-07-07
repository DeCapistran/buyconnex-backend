package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Tags;


public interface TagRepository extends JpaRepository<Tags, Long> {

	List<Tags> findByNom(String nom);
	//boolean existByTags(String tags);
}
