package com.example.springpersonapi.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomHttpResponse {
    private int statusCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy hh:mm:ss a",timezone = "Europe/Paris")
    private Date timeStamp;
    private HttpStatus status;
    private String reason;
    private String message;

    public CustomHttpResponse(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public CustomHttpResponse(int statusCode, HttpStatus status, String reason, String message) {
        this.timeStamp = new Date();
        this.statusCode = statusCode;
        this.status = status;
        this.reason = reason;
        this.message = message;
    }
}
