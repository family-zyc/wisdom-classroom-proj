package cn.zyc.wc.controller;


import cn.zyc.wc.po.R;
import cn.zyc.wc.po.SchoolSchedulePhase;
import cn.zyc.wc.service.ISchoolSchedulePhaseService;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2022-04-21
 */
@RequestMapping("/school-schedule-phase")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "School-Schedule-Phase", description = "")
public class SchoolSchedulePhaseController {

    @Autowired
    ISchoolSchedulePhaseService schoolSchedulePhaseServiceImpl;

    @GetMapping("/list")
    public R list(){
        List<SchoolSchedulePhase> list = schoolSchedulePhaseServiceImpl.list();

        return R.ok().data(list).build();
    }
}
