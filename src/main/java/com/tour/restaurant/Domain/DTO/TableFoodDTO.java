package com.tour.restaurant.Domain.DTO;

public class TableFoodDTO {

    private Long id;
    private Integer capacity;
    private Integer number;
    private Boolean isAvailable;

    //Functions:
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}

