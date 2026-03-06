package com.buyconnex.buyconnex.vo.client;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VillesVo {
	private Long id;
	private String ville;
	private Set<CommunesVo> communes;
	private Long idPays;
}
