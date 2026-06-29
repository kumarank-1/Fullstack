package com.funfit.model;

import java.time.LocalTime;

public class Batch {
    private int id;
    private String batchName;
    private String timeSlot;
    private String instructorName;
    private int capacity;
    private LocalTime startTime;
    private LocalTime endTime;

    public Batch() {
    }

    public Batch(int id, String batchName, String timeSlot, String instructorName, int capacity,
            LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.batchName = batchName;
        this.timeSlot = timeSlot;
        this.instructorName = instructorName;
        this.capacity = capacity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
