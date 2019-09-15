package com.VotreBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VotreBanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
