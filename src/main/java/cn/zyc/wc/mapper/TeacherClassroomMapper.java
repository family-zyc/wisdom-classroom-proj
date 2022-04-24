package cn.zyc.wc.mapper;

import cn.zyc.wc.po.TeacherClassroom;
import cn.zyc.wc.vo.TeacherClassroomQueryVo;
import cn.zyc.wc.vo.TeacherClassroomVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyc
 * @since 2022-04-21
 */
public interface TeacherClassroomMapper extends BaseMapper<TeacherClassroom> {

    List<TeacherClassroomVo> teacherClassroomVoListByCondition(TeacherClassroomQueryVo teacherClassroomQueryVo);

    long checkClassConflict(@Param("localDate") LocalDate localDate,
                            @Param("startPhase") Integer startPhase,
                            @Param("endPhase") Integer endPhase);
}
