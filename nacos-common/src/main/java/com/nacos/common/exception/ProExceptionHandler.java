package com.nacos.common.exception;
import com.nacos.common.util.ServiceResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public Object exceptionHandler(Exception e){
        return ServiceResponse.getFAIL();
    }
}
