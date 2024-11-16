package com.growthx.assignment.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
@Builder
public class User {

    @Id
    private String id;

    private String name;

    private String password;

    private List<Assignment> task;

}
