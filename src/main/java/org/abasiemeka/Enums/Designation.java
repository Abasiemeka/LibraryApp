package org.abasiemeka.Enums;

public enum Designation {
    TEACHER(1), STUDENT_GRADE_2(3), STUDENT_GRADE_3(2), STUDENT_GRADE_1(4); //importance level deliberately staggered for testing purposes.

    private final Integer priority; //note: priorities have been assigned in ascending order from most important to least.

    public Integer getPriority() {
        return this.priority;
    }

    private Designation(Integer priority) {
        this.priority = priority;
    }
}