package com.project.entity;

import java.time.LocalDateTime;

public class TimeTest {
    private LocalDateTime time;

    public TimeTest() {
    }

    public TimeTest(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeTest{" +
                "time=" + time +
                '}';
    }
}
