package com.alma.fournisseur.presentation;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alma.fournisseur.application.Application;
import com.alma.fournisseur.domain.Entity;


	@RestController
	public class ProductController {

		private Application app = new Application();

	    @RequestMapping("/displayOneEntity")
	    public Entity getEntity(@RequestParam(value="id", defaultValue="1") String id) {
	        return  app.getRepo().displayOneEntity(Integer.parseInt(id));
	    }
	    
	    @RequestMapping("/displayAllEntities")
	    public List<Entity> getAllEntities() {
	        return  app.getRepo().displayAllEntitys();
	    }
	    
	    @RequestMapping("/checkCreditCard")
	    public String checkCreditCard(@RequestParam(value="id", defaultValue="1") String card) {
	        return  app.getService().checkCreditCard(card);
	    }
	    
	    @RequestMapping("/buyProduct")
	    public Entity buyProduct(@RequestParam(value="id", defaultValue="1") String id,@RequestParam(value="id", defaultValue="1") String card) {
	    	
	    	if (app.getService().checkCreditCard(card).equals("false")){
	    		return null;
	    	}
	    	else{
	    		//card okay
	    		app.getRepo().updateStockPurchased(Integer.parseInt(id));
	    		return  app.getRepo().displayOneEntity(Integer.parseInt(id));
	    	}
	    }
	
}