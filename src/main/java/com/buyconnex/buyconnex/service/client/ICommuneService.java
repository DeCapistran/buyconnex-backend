package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.client.CommunesVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

public interface ICommuneService {

	public Optional<CommunesVo> findById(Long id);
	public List<CommunesVo> findAll();
	public CommunesVo saveCommunes(CommunesVo communesVo);
	public void deleteCommunes(CommunesVo communesVo);
	public void deleteCommunesById(Long id);
	public CommunesVo updateCommunes(Long id, CommunesVo communesVo);
	public List<CommunesVo> findByCommune(String commune);
	public List<CommunesVo> findByVilles(VillesVo villesVo);
}
