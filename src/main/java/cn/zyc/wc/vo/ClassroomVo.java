package cn.zyc.wc.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zyc
 * @date 2022/4/19
 */
@Data
@Builder
public class ClassroomVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("教室名称")
    private String classname;

    @ApiModelProperty("楼层")
    private Integer floor;

    @ApiModelProperty("门牌号")
    private Integer number;

    @ApiModelProperty("座位数")
    private Integer seat;

    @ApiModelProperty("教室类型，1公共教室，2专业教室，3实验室")
    private Integer typeId;

    @ApiModelProperty("教室类型")
    private String type;
}
