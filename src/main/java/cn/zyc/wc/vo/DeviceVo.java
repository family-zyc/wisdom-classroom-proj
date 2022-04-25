package cn.zyc.wc.vo;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

/**
 * @author zyc
 * @date 2022/4/25
 */
public class DeviceVo {
    @ApiModelProperty("设备id")
    private String deviceId;

    @ApiModelProperty("设备名称")
    private String deviceName;

    @ApiModelProperty("图片")
    private String deviceImage;

    @ApiModelProperty("教室id")
    private Integer classroomId;

    @ApiModelProperty("教室名字")
    private String classroomName;

    @ApiModelProperty("购入时间")
    private LocalDate buyDate;

    @ApiModelProperty("维修次数")
    private Integer fixSize;

    @ApiModelProperty("设备类型，1台式机，2投影仪，3风扇，4电灯，5空调")
    private Integer deviceType;

    @ApiModelProperty("设备类型，1台式机，2投影仪，3风扇，4电灯，5空调")
    private String deviceTypeName;

    @ApiModelProperty("是否可用：0能用，1不能用")
    private Boolean isDisable;

    @Override
    public String toString() {
        return "DeviceVo{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceImage='" + deviceImage + '\'' +
                ", classroomId=" + classroomId +
                ", classroomName='" + classroomName + '\'' +
                ", buyDate=" + buyDate +
                ", fixSize=" + fixSize +
                ", deviceType=" + deviceType +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", isDisable=" + isDisable +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceImage() {
        return deviceImage;
    }

    public void setDeviceImage(String deviceImage) {
        this.deviceImage = deviceImage;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getFixSize() {
        return fixSize;
    }

    public void setFixSize(Integer fixSize) {
        this.fixSize = fixSize;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public Boolean getDisable() {
        return isDisable;
    }

    public void setDisable(Boolean disable) {
        isDisable = disable;
    }
}
