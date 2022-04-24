package cn.zyc.wc.controller;


import cn.zyc.wc.po.Classroom;
import cn.zyc.wc.po.ClassroomType;
import cn.zyc.wc.po.R;
import cn.zyc.wc.service.IClassroomService;
import cn.zyc.wc.service.IClassroomTypeService;
import cn.zyc.wc.util.ZycTools;
import cn.zyc.wc.vo.ClassroomQueryVo;
import cn.zyc.wc.vo.ClassroomVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
 * @since 2022-04-19
 */
@RequestMapping("/classroom")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "Classroom", description = "")
public class ClassroomController {
    @Autowired
    IClassroomService classroomServiceImpl;

    @Autowired
    IClassroomTypeService classroomTypeServiceImpl;

    @GetMapping("/list")
    public R list(){
        List<Classroom> list = classroomServiceImpl.list();
        return R.ok().data(list).build();
    }

    @GetMapping("/list/{page}/{limit}")
    public R listForConditionPage(@PathVariable int page,
                                  @PathVariable int limit,
                                  ClassroomQueryVo classroomQuery) throws Exception {
        log.info("--{}",classroomQuery);
        IPage<Classroom> ipage = new Page<>(page,limit);
        QueryWrapper<Classroom> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(StringUtils.checkValNotNull(classroomQuery.getFloor()),Classroom::getFloor,classroomQuery.getFloor())
                .eq(StringUtils.checkValNotNull(classroomQuery.getNumber()),Classroom::getNumber,classroomQuery.getNumber())
                .eq(StringUtils.checkValNotNull(classroomQuery.getTypeId()),Classroom::getTypeId,classroomQuery.getTypeId())
                .ge(StringUtils.checkValNotNull(classroomQuery.getStartSeat()),Classroom::getSeat,classroomQuery.getStartSeat())
                .le(StringUtils.checkValNotNull(classroomQuery.getEndSeat()),Classroom::getSeat,classroomQuery.getEndSeat());
        classroomServiceImpl.page(ipage,wrapper);

        Map map = new HashMap<>();
        map.put("classroomList",ipage.getRecords());
        map.put("total",ipage.getTotal());
        return R.ok().data(map).build();
    }

    @GetMapping("/type")
    public R getClassroomType(){
        List<ClassroomType> list = classroomTypeServiceImpl.list();
        return R.ok().data(list).build();
    }

    @DeleteMapping("/crud/{id}")
    public R remove(@PathVariable Integer id){
        log.info("remove-id-{}",id);
        boolean result = classroomServiceImpl.removeById(id);
        return result?R.ok().build():R.fail().message("删除失败").build();
    }

    @PostMapping("/crud")
    public R save(@RequestBody ClassroomVo classroomVo){
        log.info("--{}",classroomVo);
        Classroom classroomPo = new Classroom();
        BeanUtils.copyProperties(classroomVo,classroomPo);
        boolean result = classroomServiceImpl.save(classroomPo);

        return result?R.ok().build():R.fail().message("保存失败").build();
    }

    @GetMapping("/crud/{id}")
    public R getOne(@PathVariable int id){
        Classroom classroomPo = classroomServiceImpl.getById(id);
        ClassroomVo classroomVo = ClassroomVo.builder().build();
        BeanUtils.copyProperties(classroomPo,classroomVo);

        return R.ok().data(classroomVo).build();
    }

    @PutMapping("/crud")
    public R update(@RequestBody ClassroomVo classroomVo){
        log.info("--{}",classroomVo);
        Classroom classroomPo = new Classroom();
        BeanUtils.copyProperties(classroomVo,classroomPo);
        boolean result = classroomServiceImpl.updateById(classroomPo);
        return result?R.ok().build():R.fail().message("更新失败").build();
    }

}
