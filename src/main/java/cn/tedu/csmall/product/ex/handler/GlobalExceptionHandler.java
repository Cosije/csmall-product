package cn.tedu.csmall.product.ex.handler;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.web.JsonResult;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理器
     */

    public  GlobalExceptionHandler(){
        System.out.println("创建全局异常处理器对象：GlobalExceptionHandler");
    }

    @ExceptionHandler
    public JsonResult handleBindException(BindException e) {
        log.debug("捕获到BindException：{}", e.getMessage());
        // 以下2行代码，如果有多种错误时，将随机获取其中1种错误的信息，并响应
        // 当配置了“快速失败”后，Spring Validation检查永远最多只有1种错误
        String message = e.getFieldError().getDefaultMessage();
        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST, message);
        // ===============================
        // 以上代码，如果有多种错误时，将获取所有错误信息，并响应
        // StringBuilder stringBuilder = new StringBuilder();
        // List<FieldError> fieldErrors = e.getFieldErrors();
        // for (FieldError fieldError : fieldErrors) {
        //     stringBuilder.append(fieldError.getDefaultMessage());
        //  }
        // return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST, stringBuilder.toString());
    }

    @ExceptionHandler
    public JsonResult handleConstraintViolationException(ConstraintViolationException e){
        log.debug("捕获到ConstraintViolationException：{}", e.getMessage());
        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST,e.getMessage());
    }

    @ExceptionHandler
    public JsonResult handleServiceException(ServiceException e) {
        log.debug("捕获到ServiceException：{}", e.getMessage());
        return JsonResult.fail(e.getServiceCode(),e.getMessage());
    }

    @ExceptionHandler
    public String handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.debug("捕获到HttpRequestMethodNotSupportedException：{}", e.getMessage());
        return "非法访问";
    }


}
