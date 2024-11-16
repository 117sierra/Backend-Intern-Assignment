package com.growthx.assignment.Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class ResponseUtil {
    public static <T> ResponseEntity<APIResponse<T>> getSuccessResponse(T data, ResponseStatusEnum status) {
        APIResponse<T> apiResponse = APIResponse.<T>builder()
                .data(data)
                .meta(getMetaDTOForSuccess(status))
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    public static <T> ResponseEntity<APIResponse<T>> getForbiddenResponse(T data, ResponseStatusEnum statusEnum){
        APIResponse<T> apiResponse = APIResponse.<T> builder()
                .data(data)
                .meta(getMetaDTOForForbidden(statusEnum))
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    public static ResponseMeta getMetaDTOForForbidden(ResponseStatusEnum status){
        return ResponseMeta.builder().isSuccess(Boolean.TRUE).
                responseMessage(status.getResponseDesc()).
                statusCode(status.getResponseCode())
                .build();
    }
    public static ResponseMeta getMetaDTOForSuccess(ResponseStatusEnum status) {
        return ResponseMeta.builder()
                .isSuccess(Boolean.TRUE)
                .responseMessage(status.getResponseDesc())
                //.displayMessage()
                .statusCode(status.getResponseCode())
                //.errors()
                .build();
    }

    public static <T> ResponseEntity<APIResponse<T>> getFailureResponse(T data, ResponseStatusEnum status) {
        APIResponse<T> apiResponse = new APIResponse<T>();
        //apiResponse.displayMessage(data);
        apiResponse.setMeta(getMetaDTOForFailure(data, status));
        return ResponseEntity.ok(apiResponse);
    }

    public static <T> ResponseMeta getMetaDTOForFailure(T data, ResponseStatusEnum status) {
        return ResponseMeta.builder()
                .isSuccess(Boolean.FALSE)
                .responseMessage(status.getResponseDesc())
                .displayMessage(data.toString())
                .statusCode(status.getResponseCode())
                //.errors()
                .build();
    }
}
