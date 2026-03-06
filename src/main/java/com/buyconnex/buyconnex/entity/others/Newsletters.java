package com.buyconnex.buyconnex.entity.others;

import java.time.LocalDateTime;
import com.buyconnex.buyconnex.entity.user.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
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
@Table(name = "NEWSLETTERS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Newsletters {

	@Id
    @SequenceGenerator(name = "NEWSLETTERS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWSLETTERS_SEQ_ID")
    @Column(name = "ID_NEWSLETTERS")
    private Long newletter_id;
	
	@Getter @Setter
    @Column(name = "DATE_INSCRIPTION")
    private LocalDateTime dateInscription;
	
	@Getter @Setter
    @Column(name = "DATE_DESINCRIPTION")
    private LocalDateTime dateDesinscription;
	
	@Column(name = "EMAIL")
    private String email;
	
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
    private Users users;
	
	@PrePersist
    protected void onCreate() {
		dateInscription = LocalDateTime.now();
    }
}
