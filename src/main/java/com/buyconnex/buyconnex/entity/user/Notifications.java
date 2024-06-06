package com.buyconnex.buyconnex.entity.user;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NOTIFICATIONS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notifications {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "NOTIFICATIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATIONS_SEQ_ID")
    @Column(name = "ID_NOTIFICATION")
    private Long notification_id;
	
	@Getter @Setter
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Getter @Setter
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Getter @Setter
	@Column(name = "STATUS")
    private String status;
	
	@Getter @Setter
	@Column(name = "DATE_NOTIF")
    private Date dateNotif;
	
	@Getter @Setter
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private Users users;
}
