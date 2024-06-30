package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;

public interface IStatusCommandeService {

	public Optional<StatusCommandesVo> findById(Long id);
	public List<StatusCommandesVo> findAll();
	public StatusCommandesVo saveStatusCommandes(StatusCommandesVo statusCommandesVo);
	public void deleteStatusCommandes(StatusCommandesVo statusCommandesVo);
	public void deleteStatusCommandesById(Long id);
	public StatusCommandesVo updateStatusCommandes(Long id, StatusCommandesVo statusCommandesVo);
	public List<StatusCommandesVo> findByCommandes(CommandesVo commandesVo);
	public List<StatusCommandesVo> findByStatus(String status);
}
