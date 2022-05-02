package cn.zyc.wc.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyc
 * @since 2022-04-25
 */
@TableName("t_device_state")
@ApiModel(value = "DeviceState对象", description = "")
public class DeviceState implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("设备id")
    private String deviceId;

    @ApiModelProperty("开机时间")
    private LocalDateTime startupTime;


    @ApiModelProperty("音量")
    private Integer volume;

    @ApiModelProperty("风速")
    private String windSpeed;

    @ApiModelProperty("当前状态，0关，1开")
    private Integer currentState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public LocalDateTime getStartupTime() {
        return startupTime;
    }

    public void setStartupTime(LocalDateTime startupTime) {
        this.startupTime = startupTime;
    }
    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return "DeviceState{" +
            "id=" + id +
            ", deviceId=" + deviceId +
            ", startupTime=" + startupTime +
            ", volume=" + volume +
            ", windSpeed=" + windSpeed +
            ", currentState=" + currentState +
        "}";
    }
}
