package com.growthx.assignment.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document(collection = "assignment")
public class Assignment {
    @Id
    private String id;
    @NotNull(message = "Task is null")
    @NotEmpty(message = "Fill in the task")
    private String task;
    private String userName;
    private String adminName;
    private Boolean isAccepted;
    @CreatedDate
    private LocalDateTime submissionTime;
}
