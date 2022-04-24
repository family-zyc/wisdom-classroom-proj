package cn.zyc.wc.controller;


import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.R;
import cn.zyc.wc.po.TeacherClassroom;
import cn.zyc.wc.service.ITeacherClassroomService;
import cn.zyc.wc.vo.TeacherClassroomQueryVo;
import cn.zyc.wc.vo.TeacherClassroomVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2022-04-21
 */
@RequestMapping("/teacher-classroom")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "Teacher-Classroom", description = "")
public class TeacherClassroomController {

    @Autowired
    ITeacherClassroomService teacherClassroomServiceImpl;

    @PostMapping("/crud")
    public R saveClassroomApply(@RequestBody TeacherClassroom teacherClassroom){
        log.info("saveClassroomApply--{}",teacherClassroom);
        teacherClassroom.setDayOfWeek(teacherClassroom.getDate().getDayOfWeek().getValue());
        // 查看这天的这个课时是否已经被占用了
        boolean isConflict = teacherClassroomServiceImpl.checkClassConflict(teacherClassroom.getDate(), teacherClassroom.getStartPhase(), teacherClassroom.getEndPhase());
        if(isConflict){
            return R.fail().message("时间冲突").build();
        }
        boolean result = teacherClassroomServiceImpl.save(teacherClassroom);
        return result?R.ok().build():R.fail().message("申请失败").build();
    }


    @GetMapping("/crud/{currentPage}/{limit}")
    public R listForConditionPage(@PathVariable int currentPage,
                                  @PathVariable int limit,
                                  TeacherClassroomQueryVo teacherClassroomQueryVo){
        log.info("listForConditionPage--{}",teacherClassroomQueryVo);
        Page<TeacherClassroomVo> page = PageHelper.startPage(currentPage, limit);
        List<TeacherClassroomVo> list = teacherClassroomServiceImpl.teacherClassroomVoListByCondition(teacherClassroomQueryVo);
        Map map = new HashMap<>();
        map.put("classroomApplyList",page.getResult());
        map.put("total",page.getTotal());
        return R.ok().data(map).build();
    }

    @GetMapping("/crud")
    public R listForCondition(TeacherClassroomQueryVo teacherClassroomQueryVo){
        log.info("listForConditionPage--{}",teacherClassroomQueryVo);
        List<TeacherClassroomVo> list = teacherClassroomServiceImpl.teacherClassroomVoListByCondition(teacherClassroomQueryVo);
        return R.ok().data(list).build();
    }



    @PutMapping("/crud/state")
    public R handleState(@RequestBody TeacherClassroom teacherClassroom) throws WisdomException {
        boolean result = teacherClassroomServiceImpl.updateState(teacherClassroom);
        return result?R.ok().build():R.fail().message("操作失败").build();
    }

}
