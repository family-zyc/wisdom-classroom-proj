package cn.zyc.wc.exception;

import cn.zyc.wc.po.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zyc
 * @date 2022/4/17
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {


    @ExceptionHandler(WisdomException.class)
    public R wisdomExceptionHandler(WisdomException e){
        log.info("wisdomExceptionHandler()");
        return R.fail().message(e.getMessage()).build();
    }

    @ExceptionHandler(Exception.class)
    public R wisdomExceptionHandler(Exception e){
        return R.fail().message(e.getMessage()).build();
    }
}
