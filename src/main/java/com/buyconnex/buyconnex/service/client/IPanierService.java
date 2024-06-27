package com.buyconnex.buyconnex.service.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.client.PaniersVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

public interface IPanierService {

	public Optional<PaniersVo> findById(Long id);
	public PaniersVo savePaniers(PaniersVo paniersVo);
	public void deletePaniers(PaniersVo paniersVo);
	public PaniersVo updatePaniers(Long id, PaniersVo paniersVo);
	public List<PaniersVo> findBydatePaniers(Date date);
	public List<PaniersVo> findByUsers(UsersVo usersVo);
}
