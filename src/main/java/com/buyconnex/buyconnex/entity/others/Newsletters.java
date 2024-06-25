package com.buyconnex.buyconnex.entity.others;

import java.util.Date;

import com.buyconnex.buyconnex.entity.user.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NEWSLETTERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Newsletters {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
    @SequenceGenerator(name = "NEWSLETTERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWSLETTERS_SEQ_ID")
    @Column(name = "ID_NEWSLETTERS")
    private Long newletter_id;
	
	@Getter @Setter
    @Column(name = "DATE_INSCRIPTION")
    private Date dateInscription;
	
	@Getter @Setter
    @Column(name = "DATE_DESINCRIPTION")
    private Date dateDesinscription;
	
	@Getter @Setter
	@Column(name = "EMAIL")
    private String email;
	
	@JoinColumn(name = "ID_USER")
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
    private Users users;
	
}
