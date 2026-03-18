package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.mapper.achat.LivraisonDetailMapper;
import com.buyconnex.buyconnex.repository.achat.LivraisonDetailRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsDetailsVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LivraisonDetailService implements ILivraisonDetailService {

	@Autowired
	LivraisonDetailRepository livraisonDetailRepository;
	
	@Override
	public Optional<LivraisonsDetailsVo> findById(Long id) {
		return livraisonDetailRepository.findById(id).map(LivraisonDetailMapper::toVO);
	}

	@Override
	public List<LivraisonsDetailsVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivraisonsDetailsVo saveLivraisonsDetails(LivraisonsDetailsVo livraisonsDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLivraisonsDetails(LivraisonsDetailsVo livraisonsDetailsVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLivraisonsDetailsById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LivraisonsDetailsVo updateLivraisonsDetails(Long id, LivraisonsDetailsVo livraisonsDetailsVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LivraisonsDetailsVo> findByCommandes(CommandesVo commandesVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LivraisonsDetailsVo> findByLivraisons(LivraisonsVo livraisonsVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
