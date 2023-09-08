package com.redhat;

import org.junit.Before;
import org.junit.Test;

public class LunchTimeTest {

	private FoodRulesEngine engine;

	@Before
	public void createEngine() {
		engine = new FoodRulesEngine();
		engine.init();
	}

	@Test
	public void testMenu() {
		System.out.println("\nMenu:");
		engine.go(new Question(QuestionType.MENU));
	}

// 	@Test
// 	public void testContainsWhat(){
// 		System.out.println("\nTuna sandwich contains:");
// 		engine.go(new Question(QuestionType.CONTAINS_WHAT,"Tuna Sandwich"));
// 	}

// 	@Test
// 	public void testWhatContainsEgg() {
// 		System.out.println("\nFoods containing egg");
// 		engine.go(new Question(QuestionType.WHAT_CONTAINS, "egg"));
// 	}

// 	@Test
// 	public void testWhatContainsVinegar() {
// 		System.out.println("\nFoods containing vinegar");
// 		engine.go(new Question(QuestionType.WHAT_CONTAINS, "vinegar"));
// 	}

// 	@Test
// 	public void testWhatContainsMustard() {
// 		System.out.println("\nFoods containing mustard");
// 		engine.go(new Question(QuestionType.WHAT_CONTAINS, "mustard"));
// 	}
}
