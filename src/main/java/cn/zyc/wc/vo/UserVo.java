package cn.zyc.wc.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author zyc
 * @date 2022/4/17
 */
@Data
@Builder
public class UserVo {

    private String username;
    private String password;

}
