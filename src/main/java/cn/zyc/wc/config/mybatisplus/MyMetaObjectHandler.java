package cn.zyc.wc.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis-plus自动填充
 * @author zyc
 * @date 2022/4/17
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,
                "gmtCreate", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject,
                "gmtModified", () -> LocalDateTime.now(), LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill--gmtModified");
        // 将gmtModified设置为null，避免从mybatis中查询出来的对象，再进行更新自动填充失败
        if(metaObject.hasSetter("GMT_MODIFIED")){
            metaObject.setValue("GMT_MODIFIED",null);
        }
        this.strictUpdateFill(metaObject, "gmtModified", () -> LocalDateTime.now(), LocalDateTime.class);
    }
}
