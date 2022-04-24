package cn.zyc.wc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyc
 * @date 2022/4/17
 */
@SpringBootApplication

public class MainApp {
    public static void main(String[] args){
        SpringApplication.run(MainApp.class,args);
    }

}
