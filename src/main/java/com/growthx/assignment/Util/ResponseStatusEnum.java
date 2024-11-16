package com.growthx.assignment.Util;

import lombok.Getter;

@Getter
public enum ResponseStatusEnum {
    SUCCESS("2010", "success"),
    FAILED("2010", "failed"),
    FORBIDDEN("4130", "failed");

    private final String responseCode;
    private final String responseDesc;

    ResponseStatusEnum(String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }
}