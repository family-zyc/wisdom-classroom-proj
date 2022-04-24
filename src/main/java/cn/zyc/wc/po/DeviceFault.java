package cn.zyc.wc.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyc
 * @since 2022-04-23
 */
@TableName("t_device_fault")
@ApiModel(value = "DeviceFault对象", description = "")
public class DeviceFault implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("报修时间")
    private LocalDateTime time;

    @ApiModelProperty("地点")
    private Integer classroomId;

    @ApiModelProperty("设备")
    private String deviceId;

    @ApiModelProperty("反馈教师")
    private Integer feedbackTeacherId;

    @ApiModelProperty("故障类型，1硬件，2软件")
    private Integer faultType;

    @ApiModelProperty("详情")
    private String detail;

    @ApiModelProperty("处理人员")
    private Integer handlePersonId;

    @ApiModelProperty("处理时间")
    private LocalDateTime handleTime;

    @ApiModelProperty("处理状态，0未处理，1正在处理，2已处理，3处理失败")
    private Integer handleState;

    @ApiModelProperty("逻辑删除，0未删除，1删除")
    private Integer isDeleted;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @Override
    public String toString() {
        return "DeviceFault{" +
                "id=" + id +
                ", time=" + time +
                ", classroomId=" + classroomId +
                ", deviceId='" + deviceId + '\'' +
                ", feedbackTeacherId=" + feedbackTeacherId +
                ", faultType=" + faultType +
                ", detail='" + detail + '\'' +
                ", handlePersonId=" + handlePersonId +
                ", handleTime=" + handleTime +
                ", handleState=" + handleState +
                ", isDeleted=" + isDeleted +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public Integer getHandlePersonId() {
        return handlePersonId;
    }

    public void setHandlePersonId(Integer handlePersonId) {
        this.handlePersonId = handlePersonId;
    }

    public LocalDateTime getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(LocalDateTime handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getHandleState() {
        return handleState;
    }

    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getFeedbackTeacherId() {
        return feedbackTeacherId;
    }

    public void setFeedbackTeacherId(Integer feedbackTeacherId) {
        this.feedbackTeacherId = feedbackTeacherId;
    }
    public Integer getFaultType() {
        return faultType;
    }

    public void setFaultType(Integer faultType) {
        this.faultType = faultType;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

}
