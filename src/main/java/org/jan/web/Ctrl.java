package org.jan.web;

import org.jan.dao.CompteBancaireInterface;
import org.jan.entities.CompteBancaire;
import org.jan.methodes.MethodesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/compte")
public class Ctrl {
	
	@Autowired
	private CompteBancaireInterface cbi;
	@Autowired
	private MethodesInterface mi;
	
	@RequestMapping(value="/ajout", method=RequestMethod.POST)
	public String ajout(Model model,CompteBancaire c){
		cbi.save(c);
		return "menu";	
	}
	
	@RequestMapping(value="/connexion", method=RequestMethod.POST)
	public String verif(Model model,CompteBancaire c,@RequestParam(name="nom")String nom) {
		
		if((cbi.findById(c.getCodeCompte()) != null) && (cbi.findOne(c.getNom()) == nom)) {
			return "menu";
		}else {
			return "echec";
		}
		
}
	@RequestMapping("/menu")
	public String Menu() {
		return "menu";
	}
	
	@RequestMapping("/consuCompte")
	public String Consulter(Model model,String codeCompte) {
		CompteBancaire compte=mi.consulterCompte(codeCompte);
		model.addAttribute("compte",compte);
		return "Consultation";
}
	@RequestMapping(value="/operationType",method=RequestMethod.POST)
	public String OperationType(Model model,String TypeOperation,String codeCompte1,double montant,String codeCompte2) {
		
			if(TypeOperation.equals("versement")) {
				mi.verser(codeCompte1, montant);
			}else {
				
				if(TypeOperation.equals("retrait")) {
			}
				mi.retirer(codeCompte1, montant);
				
			}if(TypeOperation.equals("virement")) {
			mi.virement(codeCompte1, codeCompte2, montant);
			}
	
	return "Reussite";
	}
}
