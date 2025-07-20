package com.example.librarymanagementsystem.dto;

import lombok.Data;
import lombok.experimental.Delegate;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

@Data
public class StandardResponse {

    private String status;
    private ResponseEntity<StandardResponse> response;
    private Object data;

    public StandardResponse(String success, ResponseEntity<StandardResponse> standardResponseResponseEntity, Object o) {
        this.status = success;
        this.response = standardResponseResponseEntity;
        this.data = o;
    }
}
