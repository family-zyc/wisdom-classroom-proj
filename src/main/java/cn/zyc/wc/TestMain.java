package cn.zyc.wc;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author zyc
 * @date 2022/4/17
 */
public class TestMain {

    private static String URL = "jdbc:mysql:///wisdom_classroom?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static void main(String[] args){
        FastAutoGenerator.create(URL,USERNAME,PASSWORD)
                .globalConfig(builder -> {
                    builder.author("zyc") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\IntelliJ IDEA\\workspace\\2204_graduation_design\\wisdom-classroom-proj\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.zyc.wc") // 设置父包名
                            .entity("po")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
//                            .xml("mapper.xml")
                            .controller("controller")

                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\IntelliJ IDEA\\workspace\\2204_graduation_design\\wisdom-classroom-proj\\src\\main\\resources\\mybatis\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_device_type") // 设置需要生成的表名
                            .addTablePrefix("t_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
