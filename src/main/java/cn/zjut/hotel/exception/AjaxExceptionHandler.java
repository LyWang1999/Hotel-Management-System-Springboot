package cn.zjut.hotel.exception;

import cn.zjut.hotel.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author kuluo
 * @description 捕获所有异常
 */
@RestControllerAdvice
public class AjaxExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(Exception e) throws Exception {
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
