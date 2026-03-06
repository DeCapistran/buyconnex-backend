package com.buyconnex.buyconnex.entity.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "NOTIFICATIONS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notifications {

	@Id
    @SequenceGenerator(name = "NOTIFICATIONS_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATIONS_SEQ_ID")
    @Column(name = "ID_NOTIFICATION")
    private Long notification_id;
	
	@Column(name = "LIBELLE")
    private String libelle;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Column(name = "STATUS")
    private String status;
	
	@Column(name = "DATE_NOTIF")
    private LocalDateTime dateNotif;
	
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private Users users;
	
	@PrePersist
    protected void onCreate() {
		dateNotif = LocalDateTime.now();
    }
}
