package cn.zyc.wc.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zyc
 * @date 2022/4/18
 */
@Data
@Builder
public class TeacherVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("教师帐号")
    private String username;

    @ApiModelProperty("教师密码")
    private String password;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("权限：1普通教师，2管理员")
    private Integer rule;

    @ApiModelProperty("教师名字")
    private String name;

    @ApiModelProperty("性别：0未知，1男，2女")
    private Integer gender;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("电话")
    private String telephone;


}
