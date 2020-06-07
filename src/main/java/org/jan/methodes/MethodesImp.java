package org.jan.methodes;

import java.util.Date;

import org.jan.dao.CompteBancaireInterface;
import org.jan.dao.OperationInterface;
import org.jan.entities.CompteBancaire;
import org.jan.entities.CompteCourant;
import org.jan.entities.Retrait;
import org.jan.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MethodesImp implements MethodesInterface{
	@Autowired
	private CompteBancaireInterface cb;
	@Autowired
	private OperationInterface oi;
	@Override
	
	public CompteBancaire consulterCompte(String codeCompte) {
		CompteBancaire compte=cb.getOne(codeCompte);
		if(compte==null) {
			System.out.println("Introuvable"); //throws exception
		}
		return compte;
	}

	@Override
	public void verser(String codeCompte, double montant) {
		CompteBancaire compte=consulterCompte(codeCompte);
		Versement v=new Versement(new Date(),montant,compte);
		oi.save(v);
		compte.setSolde(compte.getSolde()+montant);
		cb.save(compte);
		
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		CompteBancaire compte=consulterCompte(codeCompte);
		double aideBank=0;
		if(compte instanceof CompteCourant) 
			aideBank=((CompteCourant) compte).getDecouvert();	
		if(compte.getSolde()+aideBank<montant) {
			System.out.println("Solde insuffisant"); //throws exception
		}else {
		Retrait r=new Retrait(new Date(),montant,compte);
		oi.save(r);
		compte.setSolde(compte.getSolde()+montant);
		cb.save(compte);
		}
	}
	
	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant) {
		retirer(codeCompte1, montant);
		verser(codeCompte2, montant);
	}

	/*	public CompteBancaire Login(String codeCompte, String nom) {
	CompteBancaire compte=cb.getOne(codeCompte);
	if(compte==null) {
		System.out.println("Introuvable"); //throws exception
	}
	return compte;
}*/

	

}
