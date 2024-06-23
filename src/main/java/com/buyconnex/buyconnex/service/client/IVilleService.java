package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.client.CommunesVo;
import com.buyconnex.buyconnex.vo.client.PaysVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

public interface IVilleService {

	public Optional<VillesVo> findById(Long id);
	public VillesVo saveVilles(VillesVo villesVo);
	public void deleteVilles(VillesVo villesVo);
	public VillesVo updateVilles(Long id, VillesVo villesVo);
	public List<VillesVo> findByCommunes(CommunesVo communesVo);
	public List<VillesVo> findByPays(PaysVo paysVo);
	public List<VillesVo> findByVilles(String ville);
}
