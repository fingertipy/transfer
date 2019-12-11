package transfer.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import transfer.controller.ApiController;
import transfer.entity.Response;
import transfer.utils.LogUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description API异常处理器
 * @Author      dayu
 * @Date        2019/12/6 16:05
 * @Version     v1.0
 */
@RestControllerAdvice(basePackageClasses = {ApiController.class})
public class ApiExceptionHandler {

    @ExceptionHandler(CustomeException.class)
    public Response customeExceptionHandler(HttpServletRequest request, CustomeException ex) throws Exception{
        //返回异常响应
        return Response.ERROR(ex);
    }

    @ExceptionHandler(Exception.class)
    public Response defaultExceptionHandler(HttpServletRequest request, Exception ex) throws Exception{
        //打印异常日志
        LogUtils.error(ex, "哎呀! 异常了: " + request.getRequestURL());
        //返回异常响应
        return Response.ERROR();
    }
}
