package org.abasiemeka.enums;

public enum Designation {
    TEACHER(1), SENIOR_STUDENT(2), JUNIOR_STUDENT(3);
    private final Integer priority; //note: priorities have been assigned in ascending order from most important to least.
 
    
    Designation(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return this.priority;
    }
}