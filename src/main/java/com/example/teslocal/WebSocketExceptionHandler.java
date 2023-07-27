package com.example.teslocal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebSocketExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleWebSocketException(Exception ex) {
        // Handle the exception here, you can log it or take any other appropriate action
        return "An error occurred: " + ex.getMessage();
    }
}

