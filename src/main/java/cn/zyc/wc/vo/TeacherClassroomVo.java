package cn.zyc.wc.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zyc
 * @date 2022/4/21
 */
public class TeacherClassroomVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("教室id")
    private Integer classroomId;

    @ApiModelProperty("教室名字")
    private String classname;

    @ApiModelProperty("老师id")
    private Integer teacherId;

    @ApiModelProperty("老师姓名")
    private String teacherName;

    @ApiModelProperty("老师电话")
    private String teacherPhone;

    @ApiModelProperty("日期")
    private LocalDate date;

    @ApiModelProperty("第几周")
    private Integer week;

    @ApiModelProperty("星期几")
    private String dayOfWeek;

    @ApiModelProperty("开始课节")
    private Integer startPhase;

    @ApiModelProperty("结束课节")
    private Integer endPhase;

    @ApiModelProperty("详情")
    private String detail;

    @ApiModelProperty("处理状态：0未处理，1通过，2未通过")
    private Integer handleState;

    @Override
    public String toString() {
        return "TeacherClassroomVo{" +
                "id=" + id +
                ", classroomId=" + classroomId +
                ", classname='" + classname + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", date=" + date +
                ", week=" + week +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startPhase=" + startPhase +
                ", endPhase=" + endPhase +
                ", detail='" + detail + '\'' +
                ", handleState=" + handleState +
                '}';
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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

}
