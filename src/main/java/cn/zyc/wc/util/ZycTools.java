package cn.zyc.wc.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyc
 * @date 2022/4/17
 */
public class ZycTools {

    public static Map<String, Object> convert(Object object) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if(field.getName().equals("serialVersionUID")){
                continue;
            }
            field.setAccessible(true);
//            String value = field.get(object) != null ? field.get(object).toString() : "";
            Object value = field.get(object);
            if(value == null){
                continue;
            }
            map.put(field.getName(), value);
        }
        return map;
    }

}
