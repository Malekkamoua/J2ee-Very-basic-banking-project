package org.jan.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CompteBancaire implements Serializable {
	
	@Id
	@Column(unique=true)
	private String codeCompte;
	private String nom;
	private String email;
	private Date dateCreation;
	private double solde;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;

	public CompteBancaire(String codeCompte, String nom, String email, Date dateCreation, double solde) {

		this.codeCompte = codeCompte;
		this.nom = nom;
		this.email = email;
		this.dateCreation = dateCreation;
		this.solde = solde;

	}

	public CompteBancaire(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}

	public CompteBancaire() {
		super();
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	
}
