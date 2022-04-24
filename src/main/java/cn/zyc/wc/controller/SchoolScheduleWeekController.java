package cn.zyc.wc.controller;


import cn.zyc.wc.po.R;
import cn.zyc.wc.po.SchoolScheduleWeek;
import cn.zyc.wc.service.ISchoolScheduleWeekService;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2022-04-21
 */
@RequestMapping("/school-schedule-week")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "School-Schedule-Week", description = "")
public class SchoolScheduleWeekController {

    @Autowired
    ISchoolScheduleWeekService schoolScheduleWeekServiceImpl;


    /**
     * 生成一个学期周数时间对应表
     * @param startDate 第一周的时间
     * @param weekTotal 总周数
     * @param dateFormat 传入的时间格式
     */
    public void createSchoolScheduleWeekTable(String startDate,Integer weekTotal,String dateFormat){
        LocalDate startLocalDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(dateFormat));
        int fisrtDayofWeek = startLocalDate.getDayOfWeek().getValue();
        startLocalDate = startLocalDate.minusDays(fisrtDayofWeek - 1);
        for(int i=1;i<=weekTotal;i++){
            SchoolScheduleWeek schoolScheduleWeek = new SchoolScheduleWeek();
            schoolScheduleWeek.setWeek(i);
            schoolScheduleWeek.setStartDate(startLocalDate);
            schoolScheduleWeek.setEndDate(startLocalDate.plusDays(6));

            startLocalDate = startLocalDate.plusDays(7);
            schoolScheduleWeekServiceImpl.save(schoolScheduleWeek);
        }

    }

    @GetMapping("/list")
    public R list(){
        List<SchoolScheduleWeek> list = schoolScheduleWeekServiceImpl.list();
        return R.ok().data(list).build();
    }


}
