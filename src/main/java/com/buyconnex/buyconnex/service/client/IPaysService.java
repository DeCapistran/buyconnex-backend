package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.client.PaysVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

public interface IPaysService {

	public Optional<PaysVo> findById(Long id);
	public PaysVo savePays(PaysVo paysVo);
	public void deletePays(PaysVo paysVo);
	public PaysVo updatePays(Long id, PaysVo paysVo);
	public List<PaysVo> findByPays(String pays);
	public List<PaysVo> findByVilles(VillesVo villesVo);
}
