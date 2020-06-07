package org.jan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP", discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class Operation implements Serializable {
	@Id @GeneratedValue
	private Long numero;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_COMPTE")
	private CompteBancaire compte;
	
	public Operation() {
		
	};
	public Operation(Date dateOperation, double montant, CompteBancaire compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}
	
	public Date getDateOperation() {
		return dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public CompteBancaire getCompte() {
		return compte;
	}
	
	
}
