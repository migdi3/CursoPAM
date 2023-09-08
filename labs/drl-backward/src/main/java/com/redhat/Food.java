package com.redhat;

import org.kie.api.definition.type.Position;

import java.util.Objects;

public class Food {

	@Position(0)
	private String item;
	@Position(1)
	private String ingredient;
	
	public Food(String item, String ingredient) {
		this.item = item;
		this.ingredient = ingredient;
	}
	
	public Food() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Food food = (Food) o;
		return Objects.equals(item, food.item) &&
				Objects.equals(ingredient, food.ingredient);
	}

	@Override
	public int hashCode() {
		return Objects.hash(item, ingredient);
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

}
