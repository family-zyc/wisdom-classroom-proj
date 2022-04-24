package cn.zyc.wc.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zyc
 * @date 2022/3/23
 */
@Data
@Builder
public class R<T> {

    public static final int SUCCESS_CODE = 20000;
    public static final int FAIL_CODE = 20001;

    private String message;
    private int code;
    private T data;

    public static <V> R.RBuilder ok(){
        return R.<V>builder().code(SUCCESS_CODE).message("success");
    }

    public static <V> R.RBuilder fail(){
        return R.<V>builder().code(FAIL_CODE);
    }

}
