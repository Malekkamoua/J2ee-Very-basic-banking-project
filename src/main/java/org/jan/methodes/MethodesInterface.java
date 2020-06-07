package org.jan.methodes;

import org.jan.entities.CompteBancaire;


public interface MethodesInterface {
	public CompteBancaire consulterCompte(String codeCompte);
	public void verser(String codeCompte, double montant);
	public void retirer(String codeCompte, double montant);
	public void virement(String codeCompte1, String codeCompte2, double montant);
}
