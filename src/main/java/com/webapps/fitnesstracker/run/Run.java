package com.webapps.fitnesstracker.run;

import java.time.Duration;
import java.time.LocalDateTime;
//import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    @Positive
    int miles,
    Location location
){

    public Run {
        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }

    public Duration getDuration() {
        return Duration.between(startedOn,completedOn);
    }

    public Integer getAvgPace() {
        return Math.toIntExact(getDuration().toMinutes() / miles);
    }

    public Object runs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runs'");
    }

}