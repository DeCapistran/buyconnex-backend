package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.ExpeditionsVo;

public interface IExpeditionService {

	public Optional<ExpeditionsVo> findById(Long id);
	public ExpeditionsVo saveExpeditions(ExpeditionsVo expeditionsVo);
	public void deleteExpeditions(ExpeditionsVo expeditionsVo);
	public ExpeditionsVo updateExpeditions(Long id, ExpeditionsVo expeditionsVo);
	public List<ExpeditionsVo> findByCommandes(CommandesVo commandesVo);
	public List<ExpeditionsVo> findByDateExpeditions(Date date);
}
