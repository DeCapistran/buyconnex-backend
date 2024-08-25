package com.buyconnex.buyconnex.service.article;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.ArticlesImages;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.mapper.article.ArticleImageMapper;
import com.buyconnex.buyconnex.mapper.article.BoutiqueMapper;
import com.buyconnex.buyconnex.mapper.article.CategorieMapper;
import com.buyconnex.buyconnex.mapper.article.ImageMapper;
import com.buyconnex.buyconnex.mapper.visuel.SliderMapper;
import com.buyconnex.buyconnex.repository.article.ArticleImageRepository;
import com.buyconnex.buyconnex.repository.article.BoutiqueRepository;
import com.buyconnex.buyconnex.repository.article.CategorieRepository;
import com.buyconnex.buyconnex.repository.article.ImageRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.visuel.SlidersVo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImageService implements IImageService {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	ArticleImageRepository articleImageRepository;

	@Autowired
	BoutiqueRepository boutiqueRepository;
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Optional<ImagesVo> findById(Long id) {
		return imageRepository.findById(id).map(ImageMapper::toVO);
	}

	@Override
	public ImagesVo saveImages(ImagesVo imagesVo) {
		Images images = ImageMapper.toEntity(imagesVo);
		Images imagesSave = imageRepository.save(images);
		return ImageMapper.toVO(imagesSave);
	}

	@Override
	public void deleteImages(ImagesVo imagesVo) {
		Images images = ImageMapper.toEntity(imagesVo);
		imageRepository.delete(images);
	}

	@Override
	public List<ImagesVo> findByCategories(CategoriesVo categoriesVo) {
		return imageRepository.findByCategories(CategorieMapper.toEntity(categoriesVo)).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ImagesVo> findByName(String name) {
		return imageRepository.findByName(name).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ImagesVo> findBySlider(SlidersVo slidersVo) {
		return imageRepository.findBySliders(SliderMapper.toEntity(slidersVo)).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public ImagesVo getImageDetail(Long id) throws IOException {
		final Optional<Images> dbImage = imageRepository.findById(id);
		return ImageMapper.toVO(Images.builder().image_id(dbImage.get().getImage_id()).name(dbImage.get().getName()).type(dbImage.get().getType()).image(dbImage.get().getImage()).build());
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Images> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType())).body(dbImage.get().getImage());
	}

	@Override
	public List<ImagesVo> findAll() {
		return imageRepository.findAll().stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteImagesById(Long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public List<ArticlesImagesVo> uploadImageArticle(List<MultipartFile> files, Long id) throws IOException {

		List<ArticlesImagesVo> saveImage = new ArrayList<>();
		Articles articles = new Articles();
		articles.setArticle_id(id);

		for (MultipartFile file : files) {
			Images image = Images.builder()
					.name(file.getOriginalFilename())
					.type(file.getContentType())
					.image(file.getBytes())
					.build();

			Images savedImages = imageRepository.save(image);

			ArticlesImages articlesImages = new ArticlesImages();
			articlesImages.setArticles(articles);
			articlesImages.setImages(savedImages);

			saveImage.add(ArticleImageMapper.toVO(articleImageRepository.save(articlesImages)));
		}
		return saveImage;
	}

	@Override
	public ImagesVo uploadImageBoutique(MultipartFile file, Boutiques boutiques) throws IOException {

		Boutiques boutique = boutiqueRepository.save(boutiques);

		Images image = Images.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.image(file.getBytes())
				.boutiques(boutique)
				.build();

		Images savedImages = imageRepository.save(image);

		return ImageMapper.toVO(savedImages);
	}

	@Override
	public List<ImagesVo> uploadImage(List<MultipartFile> files) throws IOException {
		List<ImagesVo> saveImages = new ArrayList<>();

		for (MultipartFile file : files) {
			Images image = Images.builder()
					.name(file.getOriginalFilename())
					.type(file.getContentType())
					.image(file.getBytes())
					.build();

			saveImages.add(ImageMapper.toVO(imageRepository.save(image)));
		}
		return saveImages;
	}

	@Override
	public ImagesVo uploadImageSingle(MultipartFile file) throws IOException {

		Images image = Images.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.image(file.getBytes())
				.build(); 

		return ImageMapper.toVO(imageRepository.save(image));
	}

	@Override
	public List<ImagesVo> findByBoutique(BoutiquesVo boutiquesVo) {
		return imageRepository.findByBoutiques(BoutiqueMapper.toEntity(boutiquesVo)).stream().map(ImageMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public BoutiquesVo uploadImageBoutique(MultipartFile file, String nom, String email,
			String telephone) throws IOException {
		//String userHomeDir = System.getProperty("user.home");
		String imagesDirPath = "C:\\dev\\buyconnex\\admin\\src\\assets\\images";
		Path imagesDir = Paths.get(imagesDirPath);
		if (!Files.exists(imagesDir)) {
			Files.createDirectories(imagesDir);
		}

		String imageName = file.getOriginalFilename();
		if (imageName != null && imageName.contains(".")) {
			imageName = nom + "." + imageName.substring(imageName.lastIndexOf(".") + 1);
		}
		Path imagePath = imagesDir.resolve(imageName);
		Files.write(imagePath, file.getBytes());

		// Create and save the image object in the database
		Images image = Images.builder()
				.name(imageName)
				.type(file.getContentType())
				.image(file.getBytes())
				.url("/assets/images/" + imageName)
				.build();

		Images savedImage = imageRepository.save(image);

		// Create the boutique entity
		Boutiques boutique = new Boutiques();
		boutique.setNom(nom);
		boutique.setEmail(email);
		boutique.setTelephone(telephone);
		boutique.setImages(savedImage); // Associate the saved image with the boutique

		// Save the boutique entity
		Boutiques savedBoutique = boutiqueRepository.save(boutique);

		// Map savedBoutique to BoutiquesVo (including ImagesVo mapping)
		BoutiquesVo boutiqueVo = new BoutiquesVo();
		boutiqueVo.setNom(savedBoutique.getNom());
		boutiqueVo.setEmail(savedBoutique.getEmail());
		boutiqueVo.setTelephone(savedBoutique.getTelephone());

		ImagesVo imagesVo = new ImagesVo();
		imagesVo.setName(savedImage.getName());
		imagesVo.setType(savedImage.getType());
		imagesVo.setUrl(savedImage.getUrl());

		boutiqueVo.setImages(imagesVo);
		return boutiqueVo;
	}

	@Override
	public BoutiquesVo updateImageBoutique(Long boutiqueId, MultipartFile file, String nom, String email,
			String telephone) throws IOException {
		// Récupérer la boutique existante par son ID
		Optional<Boutiques> optionalBoutique = boutiqueRepository.findById(boutiqueId);
		if (!optionalBoutique.isPresent()) {
			throw new IllegalArgumentException("Boutique non trouvée pour l'ID: " + boutiqueId);
		}

		Boutiques boutique = optionalBoutique.get();

		// Gérer la mise à jour de l'image si un nouveau fichier est fourni
		if (file != null && !file.isEmpty()) {
			String imagesDirPath = "C:\\dev\\buyconnex\\admin\\src\\assets\\images";
			Path imagesDir = Paths.get(imagesDirPath);
			if (!Files.exists(imagesDir)) {
				Files.createDirectories(imagesDir);
			}

			String imageName = file.getOriginalFilename();
			if (imageName != null && imageName.contains(".")) {
				imageName = nom + "." + imageName.substring(imageName.lastIndexOf(".") + 1);
			}
			Path imagePath = imagesDir.resolve(imageName);
			Files.write(imagePath, file.getBytes());

			// Créer et enregistrer le nouvel objet image dans la base de données
			Images image = Images.builder()
					.name(imageName)
					.type(file.getContentType())
					.image(file.getBytes())
					.url("/assets/images/" + imageName)
					.build();

			Images savedImage = imageRepository.save(image);

			// Associer l'image enregistrée à la boutique
			boutique.setImages(savedImage);
		}

		// Mettre à jour les autres informations de la boutique
		boutique.setNom(nom);
		boutique.setEmail(email);
		boutique.setTelephone(telephone);

		// Enregistrer la boutique mise à jour
		Boutiques savedBoutique = boutiqueRepository.save(boutique);

		// Mapper savedBoutique vers BoutiquesVo (y compris le mappage de ImagesVo)
		BoutiquesVo boutiqueVo = new BoutiquesVo();
		boutiqueVo.setNom(savedBoutique.getNom());
		boutiqueVo.setEmail(savedBoutique.getEmail());
		boutiqueVo.setTelephone(savedBoutique.getTelephone());

		ImagesVo imagesVo = new ImagesVo();
		Images savedImage = savedBoutique.getImages();
		imagesVo.setName(savedImage.getName());
		imagesVo.setType(savedImage.getType());
		imagesVo.setUrl(savedImage.getUrl());

		boutiqueVo.setImages(imagesVo);

		return boutiqueVo;
	}

	@Override
	public boolean deleteBoutique(Long boutiqueId) throws IOException {
	    // Récupérer la boutique avec l'image associée
	    Optional<Boutiques> optionalBoutique = boutiqueRepository.findById(boutiqueId);
	    if (optionalBoutique.isEmpty()) {
	        throw new EntityNotFoundException("Boutique not found with ID: " + boutiqueId);
	    }

	    Boutiques boutique = optionalBoutique.get();
	    Images image = boutique.getImages();

	    // Supprimer l'image du système de fichiers
	    if (image != null) {
	        String imagePath = "C:\\dev\\buyconnex\\admin\\src\\assets\\images\\" + image.getName();
	        Path path = Paths.get(imagePath);
	        if (Files.exists(path)) {
	            Files.delete(path); // Supprime le fichier image
	        }

	        // Supprimer l'image de la base de données
	        imageRepository.delete(image);
	    }

	    // Supprimer la boutique de la base de données
	    boutiqueRepository.delete(boutique);

	    return true;
	}

	@Override
	public CategoriesVo uploadImageCategorie(MultipartFile file, String libelle) throws IOException {
				String imagesDirPath = "C:\\dev\\buyconnex\\admin\\src\\assets\\images\\categories";
				Path imagesDir = Paths.get(imagesDirPath);
				if (!Files.exists(imagesDir)) {
					Files.createDirectories(imagesDir);
				}

				String imageName = file.getOriginalFilename();
				if (imageName != null && imageName.contains(".")) {
					imageName = libelle + "." + imageName.substring(imageName.lastIndexOf(".") + 1);
				}
				Path imagePath = imagesDir.resolve(imageName);
				Files.write(imagePath, file.getBytes());

				// Create and save the image object in the database
				Images image = Images.builder()
						.name(imageName)
						.type(file.getContentType())
						.image(file.getBytes())
						.url("/assets/images/categories/" + imageName)
						.build();

				Images savedImage = imageRepository.save(image);

				// Create the categorie entity
				Categories categorie = new Categories();
				categorie.setLibelle(libelle);
				categorie.setImages(savedImage); // Associate the saved image with the categorie

				// Save the categorie entity
				Categories savedCategorie = categorieRepository.save(categorie);

				// Map savedCategorie to CategorieVo (including ImagesVo mapping)
				CategoriesVo categoriesVo = new CategoriesVo();
				categoriesVo.setLibelle(savedCategorie.getLibelle());

				ImagesVo imagesVo = new ImagesVo();
				imagesVo.setName(savedImage.getName());
				imagesVo.setType(savedImage.getType());
				imagesVo.setUrl(savedImage.getUrl());

				categoriesVo.setImages(imagesVo);
				return categoriesVo;
	}

	@Override
	public CategoriesVo updateImageCategorie(Long id, MultipartFile file, String libelle) throws IOException {
		// Récupérer la categorie existante par son ID
				Optional<Categories> optionalCategorie = categorieRepository.findById(id);
				if (!optionalCategorie.isPresent()) {
					throw new IllegalArgumentException("Categorie non trouvée pour l'ID: " + id);
				}

				Categories categories = optionalCategorie.get();

				// Gérer la mise à jour de l'image si un nouveau fichier est fourni
				if (file != null && !file.isEmpty()) {
					String imagesDirPath = "C:\\dev\\buyconnex\\admin\\src\\assets\\images\\categories";
					Path imagesDir = Paths.get(imagesDirPath);
					if (!Files.exists(imagesDir)) {
						Files.createDirectories(imagesDir);
					}

					String imageName = file.getOriginalFilename();
					if (imageName != null && imageName.contains(".")) {
						imageName = libelle + "." + imageName.substring(imageName.lastIndexOf(".") + 1);
					}
					Path imagePath = imagesDir.resolve(imageName);
					Files.write(imagePath, file.getBytes());

					// Créer et enregistrer le nouvel objet image dans la base de données
					Images image = Images.builder()
							.name(imageName)
							.type(file.getContentType())
							.image(file.getBytes())
							.url("/assets/images/categories/" + imageName)
							.build();

					Images savedImage = imageRepository.save(image);

					// Associer l'image enregistrée à la categorie
					categories.setImages(savedImage);
				}

				// Mettre à jour les autres informations de la categorie
				categories.setLibelle(libelle);

				// Enregistrer la categorie mise à jour
				Categories savedCategorie = categorieRepository.save(categories);

				// Mapper savedCategorie vers CategoriesVo (y compris le mappage de ImagesVo)
				CategoriesVo categoriesVo = new CategoriesVo();
				categoriesVo.setLibelle(savedCategorie.getLibelle());

				ImagesVo imagesVo = new ImagesVo();
				Images savedImage = savedCategorie.getImages();
				imagesVo.setName(savedImage.getName());
				imagesVo.setType(savedImage.getType());
				imagesVo.setUrl(savedImage.getUrl());

				categoriesVo.setImages(imagesVo);

				return categoriesVo;
	}

	@Override
	public boolean deleteCategorie(Long categorieId) throws IOException {
		// Récupérer la categorie avec l'image associée
	    Optional<Categories> optionalCategorie = categorieRepository.findById(categorieId);
	    if (optionalCategorie.isEmpty()) {
	        throw new EntityNotFoundException("Categorie not found with ID: " + categorieId);
	    }

	    Categories categories = optionalCategorie.get();
	    Images image = categories.getImages();

	    // Supprimer l'image du système de fichiers
	    if (image != null) {
	        String imagePath = "C:\\dev\\buyconnex\\admin\\src\\assets\\images\\categories\\" + image.getName();
	        Path path = Paths.get(imagePath);
	        if (Files.exists(path)) {
	            Files.delete(path); // Supprime le fichier image
	        }

	        // Supprimer l'image de la base de données
	        imageRepository.delete(image);
	    }

	    // Supprimer la categorie de la base de données
	    categorieRepository.delete(categories);

	    return true;
	}


}
