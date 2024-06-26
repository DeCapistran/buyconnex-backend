package com.buyconnex.buyconnex.vo.achat;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusCommandesVo {
	private Long id;
	private String status;
	private String description;
	private Set<CommandesVo> commandes;
}
