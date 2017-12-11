package edu.mum.cinema.dto;

public class Seat {
	
    private String id;
    private String rowNum;
    private String columnNum;
    private String status;
    private String price;
    
    public Seat() {
    	
    }
    
    public Seat(String rowNum, String columnNum, String status, String price){
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.status = status;
        this.price = price;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(String columnNum) {
        this.columnNum = columnNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}