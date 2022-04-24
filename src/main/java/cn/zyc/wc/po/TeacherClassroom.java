package cn.zyc.wc.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyc
 * @since 2022-04-21
 */
@TableName("t_teacher_classroom")
@ApiModel(value = "TeacherClassroom对象", description = "")
public class TeacherClassroom implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("教室id")
    private Integer classroomId;

    @ApiModelProperty("老师id")
    private Integer teacherId;

    @ApiModelProperty("日期")
    private LocalDate date;

    @ApiModelProperty("星期")
    private Integer dayOfWeek;

    @ApiModelProperty("开始课节")
    private Integer startPhase;

    @ApiModelProperty("结束课节")
    private Integer endPhase;

    @ApiModelProperty("详情")
    private String detail;

    @ApiModelProperty("处理状态：0未处理，1通过，2未通过")
    private Integer handleState;

    @ApiModelProperty("逻辑删除，0未删除，1删除")
    private Boolean isDeleted;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @Override
    public String toString() {
        return "TeacherClassroom{" +
                "id=" + id +
                ", classroomId=" + classroomId +
                ", teacherId=" + teacherId +
                ", date=" + date +
                ", dayOfWeek=" + dayOfWeek +
                ", startPhase=" + startPhase +
                ", endPhase=" + endPhase +
                ", detail='" + detail + '\'' +
                ", handleState=" + handleState +
                ", isDeleted=" + isDeleted +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Integer getStartPhase() {
        return startPhase;
    }

    public void setStartPhase(Integer startPhase) {
        this.startPhase = startPhase;
    }
    public Integer getEndPhase() {
        return endPhase;
    }

    public void setEndPhase(Integer endPhase) {
        this.endPhase = endPhase;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public Integer getHandleState() {
        return handleState;
    }

    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
    }
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
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
