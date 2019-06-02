package com.test_project.demo.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    int number;
    String name;
    Double price;
    String category;
    List<String> ingredients;

    public MenuItem(int number, String name, Double price, String category) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = new ArrayList<String>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredients(String ingredient) {
        ingredients.add(ingredient);
    }
}
