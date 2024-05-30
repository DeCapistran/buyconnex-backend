package com.buyconnex.buyconnex.repository.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.user.Users;




public interface ClientRepository extends JpaRepository<Clients, Long> {

	List<Clients> findByAdresses(Adresses adresses);
	List<Clients> findByCommandes(Commandes commandes);
	Optional<Clients> findByEntreprise(String entreprise);
	List<Clients> findByFristname(String fristname);
	List<Clients> findByLastname(String lastname);
	List<Clients> findByUsers(Users users);
}
