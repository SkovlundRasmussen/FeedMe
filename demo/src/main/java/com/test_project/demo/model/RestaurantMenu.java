package com.test_project.demo.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection="RestaurantMenu")
public class RestaurantMenu {

    @Id
    private Long id;

    @Indexed(unique = true)
    @Field(value = "RestaurantID")
    private String restaurantId;

    @Field(value = "RestaurantName")
    private String restaurantName;

    public RestaurantMenu(String restaurantName, RestaurantAddress address, List<MenuItem> menu) {
        this.restaurantName = restaurantName;
        this.menu = new ArrayList<MenuItem>();
    }

    private RestaurantAddress address;

    private List<MenuItem> menu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public RestaurantAddress getAddress() {
        return address;
    }

    public void setAddress(RestaurantAddress address) {
        this.address = address;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ", restaurantName:" + this.restaurantName + ", address:" + this.address + ", menu:" + this.menu;
    }
}
