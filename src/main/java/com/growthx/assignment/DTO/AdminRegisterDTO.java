package com.growthx.assignment.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AdminRegisterDTO {
    @NotNull(message = "Name is null")
    @NotEmpty(message = "Fill the name")
    private String name;
    @NotNull(message = "Password is null")
    @NotEmpty(message = "Fill the password")
    private String password;
}
