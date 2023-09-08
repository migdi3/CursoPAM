package com.redhat;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class FoodRulesEngine {
	KieSession session;
	
	public void init() {
		KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
		session = kc.newKieSession( "LTSession");	
		createMenu();
	}
	
	public void go(Question query){
		session.insert(query);
		session.fireAllRules();
	}
	
	private void createMenu() {
		//Insert facts for all the food item to ingredient relationships for all sandwiches on the menu
		session.insert(new Food("mayonnaise", "egg"));
		session.insert(new Food("mayonnaise", "oil"));
		session.insert(new Food("mayonnaise", "vinegar"));
		session.insert(new Food("mustard", "vinegar"));
		session.insert(new Food("mustard", "turmeric"));
		session.insert(new Food("mustard", "mustard seed"));
		session.insert(new Food("tuna salad", "albacore tuna"));
		session.insert(new Food("tuna salad", "mayonnaise"));
		session.insert(new Food("tuna salad", "relish"));
		session.insert(new Food("relish", "cucumber"));
		session.insert(new Food("relish", "vinegar"));
		session.insert(new Food("relish", "sugar"));
		session.insert(new Food("peanut butter", "sugar"));
		session.insert(new Food("peanut butter", "roasted peanuts"));
		session.insert(new Food("peanut butter", "oil"));
		session.insert(new Food("jelly", "sugar"));
		session.insert(new Food("jelly", "grapes"));
		session.insert(new Food("jelly", "pectin"));
		session.insert(new Food("Egg Salad Sandwich", "boiled egg"));
		session.insert(new Food("Egg Salad Sandwich", "mayonnaise"));
		session.insert(new Food("Egg Salad Sandwich", "white bread"));
		session.insert(new Food("Ham Sandwich", "ham"));
		session.insert(new Food("Ham Sandwich", "wheat bread"));
		session.insert(new Food("Ham Sandwich", "mustard"));
		session.insert(new Sandwich("Ham Sandwich"));
		session.insert(new Food("Ham and Cheese Sandwich", "ham"));
		session.insert(new Food("Ham and Cheese Sandwich", "wheat bread"));
		session.insert(new Food("Ham and Cheese Sandwich", "mustard"));
		session.insert(new Food("Ham and Cheese Sandwich", "swiss cheese"));
		session.insert(new Sandwich("Ham and Cheese Sandwich"));
		session.insert(new Food("Grilled Cheese Sandwich", "american cheese"));
		session.insert(new Food("Grilled Cheese Sandwich", "white bread"));
		session.insert(new Food("Grilled Cheese Sandwich", "butter"));
		session.insert(new Sandwich("Grilled Cheese Sandwich"));
		session.insert(new Sandwich("Egg Salad Sandwich"));
		session.insert(new Food("Tuna Sandwich", "wheat bread"));
		session.insert(new Food("Tuna Sandwich","tuna salad"));
		session.insert(new Sandwich("Tuna Sandwich"));
		session.insert(new Food("PBJ Sandwich", "peanut butter"));
		session.insert(new Food("PBJ Sandwich","jelly"));
		session.insert(new Food("PBJ Sandwich","white bread"));
		session.insert(new Sandwich("PBJ Sandwich"));
	}
}
