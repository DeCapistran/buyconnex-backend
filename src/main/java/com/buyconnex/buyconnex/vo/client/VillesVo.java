package com.buyconnex.buyconnex.vo.client;

import java.util.Set;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Pays;

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
	private Set<Communes> communes;
	private Pays pays;
}
