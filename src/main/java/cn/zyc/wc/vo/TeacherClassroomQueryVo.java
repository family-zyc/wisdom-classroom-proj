package cn.zyc.wc.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author zyc
 * @date 2022/4/21
 */
public class TeacherClassroomQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("教室id")
    private Integer classId;

    @ApiModelProperty("教室名字")
    private String classname;

    @ApiModelProperty("老师id")
    private Integer teacherId;

    @ApiModelProperty("老师姓名")
    private String teacherName;

    @ApiModelProperty("日期")
    private LocalDate date;

    @ApiModelProperty("第几周")
    private Integer week;

    @ApiModelProperty("星期几")
    private Integer dayOfWeek;

    @ApiModelProperty("开始课节")
    private Integer startPhase;

    @ApiModelProperty("结束课节")
    private Integer endPhase;

    @ApiModelProperty("处理状态：0未处理，1通过，2未通过")
    private Integer handleState;

    @Override
    public String toString() {
        return "TeacherClassroomQueryVo{" +
                "classId=" + classId +
                ", classname='" + classname + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", date=" + date +
                ", week=" + week +
                ", dayOfWeek=" + dayOfWeek +
                ", startPhase=" + startPhase +
                ", endPhase=" + endPhase +
                ", handleState=" + handleState +
                '}';
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
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

    public Integer getHandleState() {
        return handleState;
    }

    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
    }

}
