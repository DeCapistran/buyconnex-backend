package com.buyconnex.buyconnex.vo.achat;

import java.util.Set;

import com.buyconnex.buyconnex.entity.achat.Livraisons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusLivraisonsVo {
	private Long id;
	private String status;
	private String description;
	private Set<Livraisons> livraisons;
}
