package org.jan.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait( Date dateOperation, double montant, CompteBancaire compte) {
		super(dateOperation, montant, compte);
	}

	
}
