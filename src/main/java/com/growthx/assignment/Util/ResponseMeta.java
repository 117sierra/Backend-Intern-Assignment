package com.growthx.assignment.Util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseMeta {
    @JsonProperty("isSuccess")
    private boolean isSuccess;

    @JsonProperty("statusCode")
    private String statusCode;

    @JsonProperty("responseMessage")
    private String responseMessage;

    @JsonProperty("displayMessage")
    private String displayMessage;

}

