package com.techtree.common.exception;

import com.techtree.common.api.CommonResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Dysprosium
 * @title: GlobalExceptionHandle
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2611:48
 */


@ControllerAdvice
public class GlobalExceptionHandle {

    {
        System.out.println("Exception handler");
    }


    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public CommonResult handApiException(ApiException e) {
        System.out.println("Api Exception");
        if (e.getResultCode() != null) {
            return CommonResult.failed(e.getResultCode());
        }
        return CommonResult.failed(e.getMessage());
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return CommonResult.failed(message);
    }



    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResult handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return CommonResult.validateFailed(message);
    }

}
