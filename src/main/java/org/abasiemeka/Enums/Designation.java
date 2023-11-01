package org.abasiemeka.Enums;

public enum Designation {
    TEACHER(1), STUDENT_GRADE_1(2), STUDENT_GRADE_2(3), STUDENT_GRADE_3(4);

    private final int priority;

    public int getPriority() {
        return this.priority;
    }

    private Designation(int priority) {
        this.priority = priority;
    }
}