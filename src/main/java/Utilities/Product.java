package Utilities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty type;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty price;
    private final SimpleIntegerProperty entity;
    private final SimpleStringProperty country;

    public Product(int id, String type, String name, int price,int entity,String country){
        this.id = new SimpleIntegerProperty(id);
        this.type = new SimpleStringProperty(type);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.entity = new SimpleIntegerProperty(entity);
        this.country = new SimpleStringProperty(country);
    }

    public int getEntity() {
        return entity.get();
    }

    public int getId() {
        return id.get();
    }

    public int getPrice() {
        return price.get();
    }

    public String getCountry() {
        return country.get();
    }

    public String getName() {
        return name.get();
    }

    public String getType() {
        return type.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleIntegerProperty entityProperty() {
        return entity;
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }
    public void setEntity(int entity) {
        this.entity.set(entity);
    }



}
