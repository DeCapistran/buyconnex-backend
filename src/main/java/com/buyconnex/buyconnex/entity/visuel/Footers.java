package com.buyconnex.buyconnex.entity.visuel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "FOOTERS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Footers {

	@Id
    @SequenceGenerator(name = "FOOTERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOTERS_SEQ_ID")
    @Column(name = "ID_FOOTERS")
    private Long footer_id;
	
	@Column(name = "TELEPHONE")
    private String telephone;
	
	@Column(name = "ADRESSE")
    private String adresse;
	
	@Column(name = "MAIL_SUPPORT")
    private String mailSupport;

}
