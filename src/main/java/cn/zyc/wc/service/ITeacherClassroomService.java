package cn.zyc.wc.service;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.TeacherClassroom;
import cn.zyc.wc.vo.TeacherClassroomQueryVo;
import cn.zyc.wc.vo.TeacherClassroomVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyc
 * @since 2022-04-21
 */
public interface ITeacherClassroomService extends IService<TeacherClassroom> {

    List<TeacherClassroomVo> teacherClassroomVoListByCondition(TeacherClassroomQueryVo teacherClassroomQueryVo);

    /**
     * 检查课时是否冲突
     * @param localDate
     * @param startPhase
     * @param endPhase
     * @return
     */
    boolean checkClassConflict(LocalDate localDate, Integer startPhase, Integer endPhase);

    boolean updateState(TeacherClassroom teacherClassroom) throws WisdomException;
}
