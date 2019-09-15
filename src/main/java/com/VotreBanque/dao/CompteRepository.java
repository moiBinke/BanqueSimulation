
package com.VotreBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VotreBanque.entities.Compte;
public interface CompteRepository extends JpaRepository<Compte,String> {

}
