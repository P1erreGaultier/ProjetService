package com.alma.fournisseur.infrastructure;

import com.alma.fournisseur.api.IService;
import com.alma.wsimport.CheckCreditCardService;

public class Service implements IService{

	public String checkCreditCard(String card) {      
        
		CheckCreditCardService service =  new CheckCreditCardService();
		com.alma.wsimport.CheckCreditCard ccc = service.getCheckCreditCard();
		return ccc.validateCard(card);
		
	}
}