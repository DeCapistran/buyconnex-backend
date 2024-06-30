package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.FacturationsVo;

public interface IFacturationService {

	public Optional<FacturationsVo> findById(Long id);
	public List<FacturationsVo> findAll();
	public FacturationsVo saveFacturations(FacturationsVo facturationsVo);
	public void deleteFacturations(FacturationsVo facturationsVo);
	public void deletefacturationsById(Long id);
	public FacturationsVo updateFacturations(Long id, FacturationsVo facturationsVo);
	public List<FacturationsVo> findByDateFacturation(Date date);
	public List<FacturationsVo> findByCommandes(CommandesVo commandesVo);
}
