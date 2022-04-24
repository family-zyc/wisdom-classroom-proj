package cn.zyc.wc.service.impl;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.TeacherClassroom;
import cn.zyc.wc.mapper.TeacherClassroomMapper;
import cn.zyc.wc.service.ITeacherClassroomService;
import cn.zyc.wc.vo.TeacherClassroomQueryVo;
import cn.zyc.wc.vo.TeacherClassroomVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyc
 * @since 2022-04-21
 */
@Service
public class TeacherClassroomServiceImpl extends ServiceImpl<TeacherClassroomMapper, TeacherClassroom> implements ITeacherClassroomService {

    @Override
    public List<TeacherClassroomVo> teacherClassroomVoListByCondition(TeacherClassroomQueryVo teacherClassroomQueryVo) {
        List<TeacherClassroomVo> list = baseMapper.teacherClassroomVoListByCondition(teacherClassroomQueryVo);
        /*return list.stream().map(teacherClassroomVo -> {
            LocalDate localDate = teacherClassroomVo.getDate();
            teacherClassroomVo.setDayOfWeek(localDate.getDayOfWeek().name().toLowerCase());
            return teacherClassroomVo;
        }).collect(Collectors.toList());*/
        return list;

    }

    @Override
    public boolean checkClassConflict(LocalDate localDate, Integer startPhase, Integer endPhase) {

        long count = baseMapper.checkClassConflict(localDate, startPhase, endPhase);

        return count>0?true:false;
    }

    @Override
    public boolean updateState(TeacherClassroom teacherClassroom) throws WisdomException {
        int result = 0;
        // 申请拒绝操作
        if(teacherClassroom.getHandleState() == 2){
            result = baseMapper.updateById(teacherClassroom);
            return result>0?true:false;
        }


        boolean isConflict = this.checkClassConflict(teacherClassroom.getDate(), teacherClassroom.getStartPhase(), teacherClassroom.getEndPhase());
        if(isConflict){
            throw new WisdomException("时间冲突,未通过");
        }
        result = baseMapper.updateById(teacherClassroom);
        return result>0?true:false;
    }
}
