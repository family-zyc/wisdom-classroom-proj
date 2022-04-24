package cn.zyc.wc.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zyc
 * @date 2022/4/19
 */
@Builder
public class ClassroomQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;



    @ApiModelProperty("楼层")
    private Integer floor;

    @ApiModelProperty("门牌号")
    private Integer number;

    @ApiModelProperty("开始座位数")
    private Integer startSeat;
    @ApiModelProperty("结束座位数")
    private Integer endSeat;

    @ApiModelProperty("教室类型，1公共教室，2专业教室，3实验室")
    private Integer typeId;

    @Override
    public String toString() {
        return "ClassroomQueryVo{" +
                "floor=" + floor +
                ", number=" + number +
                ", startSeat=" + startSeat +
                ", endSeat=" + endSeat +
                ", typeId=" + typeId +
                '}';
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStartSeat() {
        return startSeat;
    }

    public void setStartSeat(Integer startSeat) {
        this.startSeat = startSeat;
    }

    public Integer getEndSeat() {
        return endSeat;
    }

    public void setEndSeat(Integer endSeat) {
        this.endSeat = endSeat;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
