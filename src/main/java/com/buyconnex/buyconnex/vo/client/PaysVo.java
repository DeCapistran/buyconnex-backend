package com.buyconnex.buyconnex.vo.client;

import java.util.Set;

import com.buyconnex.buyconnex.entity.client.Villes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaysVo {
	private Long id;
	private String pays;
	private Set<Villes> villes;
}
