package de.uni.koeln.se.bookstore.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String author;
    private Integer dateyear;
    private Integer price;
    
    public Book() {}

    public Book(String name, String author, Integer dateyear, Integer price) {
        this.name = name;
        this.author = author;
        this.dateyear = dateyear;
        this.price = price;
    }

        // getters and Setters
        
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public Integer getDateyear() {
        return this.dateyear;
    }

    public void setDateyear(Integer dateyear) {
        this.dateyear = dateyear;
    }
   
  

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    

    
}
