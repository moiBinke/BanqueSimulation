package com.VotreBanque.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.VotreBanque.entities.Compte;
import com.VotreBanque.entities.Operation;

public interface IBanqueMetier {

	 public Compte getCompte(String codeCompte);
	 public void versement(String codeCompte, double montant );
	 public void retrait(String codeCompte, double montant );
	 public void virement(String codeCompteRetrait,String codeCompteVersement,double montant);
    

	  public Page<Operation> listOperationCompte(String codeCompte,int page,int sizePage);
	/* 
	 public List<Operation> listOperationsCompte(String codeCompte);
	*/	
}