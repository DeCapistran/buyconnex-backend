package com.buyconnex.buyconnex.repository.user;

import com.buyconnex.buyconnex.entity.user.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, Long> {
    public Contacts getContactById(Long id);
}
