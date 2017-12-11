package edu.mum.cinema.dto;

public class SectionPrice {
    private String id;
    private String section;
    private Double price;
    
    public SectionPrice() {
    	
    }
    
    public SectionPrice(String sectionName, Double price){
        this.section = sectionName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}