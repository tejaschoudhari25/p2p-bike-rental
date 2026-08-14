package com.bikerental.dto.request;

import java.time.LocalDate;

public class BookingRequest {
    private Long userId;
    private Long bikeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public BookingRequest(){}
    
    public BookingRequest(Long userId, Long bikeId, LocalDate startDate, LocalDate endDate, String status){
        this.userId = userId;
        this.bikeId = bikeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId = userId; }

    public Long getBikeId(){ return bikeId; }
    public void setBikeId(Long bikeId){ this.bikeId = bikeId; }

    public LocalDate getStartDate(){ return startDate; }
    public void setStartDate(LocalDate startDate){ this.startDate = startDate; }

    public LocalDate getEndDate(){ return endDate; }
    public void setEndDate(LocalDate endDate){ this.endDate = endDate; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
}
