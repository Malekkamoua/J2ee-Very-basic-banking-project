package org.jan;

import java.util.Date;
import org.jan.dao.CompteBancaireInterface;
import org.jan.dao.OperationInterface;
import org.jan.entities.CompteBancaire;
import org.jan.entities.CompteCourant;
import org.jan.entities.CompteEpargne;
import org.jan.entities.Operation;
import org.jan.entities.Retrait;
import org.jan.entities.Versement;
import org.jan.methodes.MethodesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BankProjApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BankProjApplication.class, args);
		CompteBancaireInterface cbi=ctx.getBean(CompteBancaireInterface.class);
		OperationInterface co=ctx.getBean(OperationInterface.class);
		MethodesInterface mi=ctx.getBean(MethodesInterface.class);
		
		
		CompteBancaire cb1=new CompteBancaire("c1", "Malek", "Malek@kamoua", new Date(), 10000);
		Operation op1=new Versement(new Date(),457,cb1);
		co.save(op1);
		Operation op2=new Retrait(new Date(),100,cb1);
		co.save(op2);
		mi.retirer("c1",150);
		
	}
	}



