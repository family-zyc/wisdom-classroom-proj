package cn.zyc.wc.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @author zyc
 * @date 2022/4/24
 */
public class DeviceFaultVo {

    private Integer id;

    @ApiModelProperty("报修时间")
    private LocalDateTime time;

    @ApiModelProperty("地点Id")
    private Integer classroomId;

    @ApiModelProperty("地点")
    private String classroomName;

    @ApiModelProperty("设备Id")
    private String deviceId;

    @ApiModelProperty("设备")
    private String deviceName;

    @ApiModelProperty("反馈教师Id")
    private Integer feedbackTeacherId;

    @ApiModelProperty("反馈教师")
    private String feedbackTeacherName;

    @ApiModelProperty("故障类型，1硬件，2软件")
    private Integer faultType;

    @ApiModelProperty("详情")
    private String detail;

    @ApiModelProperty("处理人员")
    private Integer handlePersonId;

    @ApiModelProperty("处理人员")
    private String handlePersonName;

    @ApiModelProperty("处理时间")
    private LocalDateTime handleTime;

    @ApiModelProperty("处理状态，0未处理，1正在处理，2已处理，3处理失败")
    private Integer handleState;

    @Override
    public String toString() {
        return "DeviceFaultVo{" +
                "id=" + id +
                ", time=" + time +
                ", classroomId=" + classroomId +
                ", classroomName='" + classroomName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", feedbackTeacherId=" + feedbackTeacherId +
                ", feedbackTeacherName='" + feedbackTeacherName + '\'' +
                ", faultType=" + faultType +
                ", detail='" + detail + '\'' +
                ", handlePersonId=" + handlePersonId +
                ", handlePersonName='" + handlePersonName + '\'' +
                ", handleTime=" + handleTime +
                ", handleState=" + handleState +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getFeedbackTeacherName() {
        return feedbackTeacherName;
    }

    public void setFeedbackTeacherName(String feedbackTeacherName) {
        this.feedbackTeacherName = feedbackTeacherName;
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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

    public Integer getHandlePersonId() {
        return handlePersonId;
    }

    public void setHandlePersonId(Integer handlePersonId) {
        this.handlePersonId = handlePersonId;
    }

    public String getHandlePersonName() {
        return handlePersonName;
    }

    public void setHandlePersonName(String handlePersonName) {
        this.handlePersonName = handlePersonName;
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

}
