package com.VotreBanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.VotreBanque.dao.ClientRepository;
import com.VotreBanque.dao.CompteRepository;
import com.VotreBanque.dao.OperationRepository;
import com.VotreBanque.entities.Client;
import com.VotreBanque.entities.Compte;
import com.VotreBanque.entities.CompteCourant;
import com.VotreBanque.entities.CompteEpargne;
import com.VotreBanque.entities.Retrait;
import com.VotreBanque.entities.Versement;
import com.VotreBanque.metier.IBanqueMetier;

@SpringBootApplication
public class VotreBanqueApplication  implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	//pour tester la couche metier
    @Autowired
   	private IBanqueMetier iBanqueMetier;
	public static void main(String[] args){
		SpringApplication.run(VotreBanqueApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Client client1 = clientRepository.save(new Client("Hassan","hassan@gmail.com"));  // ici, la methode save de IClientRepository qui extends de JpaRepository<Client,Long>  enregistre  dans la base et en plus retourne le  Client enregistrÃ©
		Client client2 = clientRepository.save(new Client("Issa","Issa@gmail.com"));
		 
		Compte compte1 = compteRepository.save(new CompteCourant("compte1",new Date(),90000.0 ,client1,6000.0));
		Compte compte2 = compteRepository.save(new CompteEpargne("compte2",new Date(),6000.0, client2, 5.5));
		 
		//operations de compte1
		  operationRepository.save(new Versement( new Date(), 9000.0,compte1));
		  operationRepository.save(new Versement( new Date(), 6000.0,compte1));
	      operationRepository.save(new Versement( new Date(), 2300.0,compte1));
		
		 operationRepository.save(new Retrait( new Date(),9000.0,compte1));
		
		
		//operations de compte2
		  operationRepository.save(new Versement( new Date(), 2300.0,compte2));
		  operationRepository.save(new Versement( new Date(), 400.0,compte2));
	      operationRepository.save(new Versement( new Date(), 2300.0,compte2));
		
		 operationRepository.save(new Retrait( new Date(),3000.0,compte2));
		 
		 //Tester la couche Metier
		 
		 iBanqueMetier.versement("compte1",111111.0);
		 
	//	 iOperationRepository.listOperation("compte1",new  PageRequest(2,2));
	//   System.out.println(	 iOperationRepository.listOperation(   "compte1",  new  PageRequest(2,2)   )      ); 
	

	}

}
