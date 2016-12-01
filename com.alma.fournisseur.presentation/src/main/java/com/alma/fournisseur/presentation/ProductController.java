package com.alma.fournisseur.presentation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alma.fournisseur.application.Application;
import com.alma.fournisseur.domain.Entity;

public class ProductController {

	@RestController
	public class GreetingController {

		private Application app = new Application();

	    @RequestMapping("/displayOneEntity")
	    public Entity getEntity(@RequestParam(value="id", defaultValue="1") String id) {
	        return app.getRepo().displayOneEntity(Integer.parseInt(id));
	    }
	}
}
