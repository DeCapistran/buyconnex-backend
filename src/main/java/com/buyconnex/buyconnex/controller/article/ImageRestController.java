package com.buyconnex.buyconnex.controller.article;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.repository.article.BoutiqueRepository;
import com.buyconnex.buyconnex.repository.article.ImageRepository;
import com.buyconnex.buyconnex.service.article.BoutiqueService;
import com.buyconnex.buyconnex.service.article.ImageService;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageRestController {

	@Autowired
	ImageService imageService;
	
	@Autowired
	BoutiqueService boutiqueService;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	BoutiqueRepository boutiqueRepository;
	
	@GetMapping
	public ResponseEntity<List<ImagesVo>> findAllImages() {
		List<ImagesVo> image = imageService.findAll();
		return ResponseEntity.ok(image);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ImagesVo> findImageById(@PathVariable Long id) {
		ImagesVo image = imageService.findById(id).isPresent() ? imageService.findById(id).get() : null;
		return image != null ? ResponseEntity.ok(image) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ImagesVo> saveImage(@Valid @RequestBody ImagesVo imagesVo) {
		ImagesVo image = imageService.saveImages(imagesVo);
		return ResponseEntity.status(201).body(image);
	}
	
	@PostMapping(value = "/upload")
	public ResponseEntity<ImagesVo> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		ImagesVo image = imageService.uploadImageSingle(file);
		return ResponseEntity.status(201).body(image);
	}
	
	@PostMapping(value = "/upload-boutique")
	public ResponseEntity<ImagesVo> uploadImageBoutique(@RequestParam("image")MultipartFile file, Boutiques boutiques) throws IOException {
		ImagesVo image = imageService.uploadImageBoutique(file, boutiques);
		return ResponseEntity.status(201).body(image);
	}
	
	@GetMapping("get-image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
		return imageService.getImage(id) != null ? imageService.getImage(id) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("details-image/{id}")
	public ResponseEntity<ImagesVo> getDetailsImage(@PathVariable Long id) throws IOException {
		ImagesVo image = imageService.getImageDetail(id);
		return image != null ? ResponseEntity.ok(image) : ResponseEntity.notFound().build();
	}
	
	@PostMapping(value = "/uploadfs-boutique", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<BoutiquesVo> uploadFSBoutique(@RequestParam("img") MultipartFile file,  
			@RequestParam("name") String nom,
            @RequestParam("email") String email,
            @RequestParam("contact") String telephone) throws IOException {
	    BoutiquesVo boutiqueVo = imageService.uploadImageBoutique(file, nom, email, telephone);
	    return ResponseEntity.ok(boutiqueVo);
	}
	
	@PostMapping(value = "/updatefs-boutique/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<BoutiquesVo> updateFSBoutique(@RequestParam("id") Long id,@RequestParam(value = "img", required = false) MultipartFile file,  
			@RequestParam("name") String nom,
            @RequestParam("email") String email,
            @RequestParam("contact") String telephone) throws IOException {
	    BoutiquesVo boutiqueVo = imageService.updateImageBoutique(id, file, nom, email, telephone);
	    return ResponseEntity.ok(boutiqueVo);
	}
	
	@DeleteMapping("/delete-boutique/{id}")
    public ResponseEntity<Void> deleteBoutique(@PathVariable Long id) {
        try {
            imageService.deleteBoutique(id);
            return ResponseEntity.noContent().build(); // Retourne un statut 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retourne un statut 404 Not Found
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retourne un statut 500 Internal Server Error
        }
    }
	
	@PostMapping(value = "/uploadfs-categorie", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<CategoriesVo> uploadFSCategorie(@RequestParam("img") MultipartFile file,  
			@RequestParam("libelle") String libelle) throws IOException {
	    CategoriesVo categoriesVo = imageService.uploadImageCategorie(file, libelle);
	    return ResponseEntity.ok(categoriesVo);
	}
	
	@PostMapping(value = "/updatefs-categorie/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<CategoriesVo> updateFSCategorie(@RequestParam("id") Long id,@RequestParam(value = "img", required = false) MultipartFile file,  
			@RequestParam("libelle") String libelle) throws IOException {
	    CategoriesVo categoriesVo = imageService.updateImageCategorie(id, file, libelle);
	    return ResponseEntity.ok(categoriesVo);
	}
	
	@DeleteMapping("/delete-categorie/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        try {
            imageService.deleteCategorie(id);
            return ResponseEntity.noContent().build(); // Retourne un statut 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retourne un statut 404 Not Found
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retourne un statut 500 Internal Server Error
        }
    }
	
	@PostMapping(value = "/uploadfs-article", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ArticlesVo> uploadFSArticle(@RequestParam("img") MultipartFile file,  
			@RequestParam("title") String title, 
			@RequestParam("quantite") int quantite, 
			@RequestParam("marque_id") Long marque_id, 
			@RequestParam("prix") Long prix, 
			@RequestParam("categorie_id") Long categorie_id, 
			@RequestParam("boutique_id") Long boutique_id, 
			@RequestParam("tag_id") Long tag_id, 
			@RequestParam("description") String description) throws IOException {
	    ArticlesVo articlesVo = imageService.uploadImageArticle(file, title, quantite, marque_id, prix, categorie_id, boutique_id, tag_id, description);
	    return ResponseEntity.ok(articlesVo);
	}
	
	@PostMapping(value = "/updatefs-article/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ArticlesVo> updateFSArticle(@RequestParam("id") Long id,
			@RequestParam(value = "img", required = false) MultipartFile file,  
			@RequestParam("title") String title,
			@RequestParam("quantite") int quantite, 
			@RequestParam("marque_id") Long marque_id, 
			@RequestParam("prix") Long prix, 
			@RequestParam("categorie_id") Long categorie_id, 
			@RequestParam("boutique_id") Long boutique_id, 
			@RequestParam("tag_id") Long tag_id, 
			@RequestParam("description") String description) throws IOException {
	    ArticlesVo articlesVo = imageService.updateImageArticle(id, file, title, quantite, marque_id, prix, categorie_id, boutique_id, tag_id, description);
	    return ResponseEntity.ok(articlesVo);
	}
	
	@DeleteMapping("/delete-article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        try {
            imageService.deleteArticle(id);
            return ResponseEntity.noContent().build(); // Retourne un statut 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retourne un statut 404 Not Found
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retourne un statut 500 Internal Server Error
        }
    }

	@PostMapping(value = "/uploadfs-article-couleur", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ArticlesImagesVo> uploadFSArticleCouleur(
			@RequestParam("img") MultipartFile file,
			@RequestParam("article_id") Long article_id,
			@RequestParam("couleur_id") Long couleur_id) throws IOException {
		ArticlesImagesVo articlesImagesVo = imageService.uploadImageArticleCouleur(file, article_id, couleur_id);
		return ResponseEntity.status(201).body(articlesImagesVo);
	}
}
