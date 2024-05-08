package com.tour.restaurant.Domain.DTO;

import java.util.Date;

public class BookingDTO {
    private Long id;
    private Integer numberOfPeople;
    private Date date;
    private Integer food;
    private Boolean status;
    private Boolean statusPayment;
    private Integer idRestaurant;
    private Integer idTableFood;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(Boolean statusPayment) {
        this.statusPayment = statusPayment;
    }

    public Integer getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Integer idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public Integer getIdTableFood() {
        return idTableFood;
    }

    public void setIdTableFood(Integer idTableFood) {
        this.idTableFood = idTableFood;
    }
}