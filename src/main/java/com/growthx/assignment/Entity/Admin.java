package com.growthx.assignment.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")
@Data
@Builder
public class Admin {

    @Id
    private String id;

    private String name;

    private String password;
}
