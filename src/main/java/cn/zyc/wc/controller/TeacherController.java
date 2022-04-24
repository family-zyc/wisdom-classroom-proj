package cn.zyc.wc.controller;


import cn.zyc.wc.po.R;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.service.ITeacherService;
import cn.zyc.wc.util.JwtUtil;
import cn.zyc.wc.vo.TeacherVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.util.BeanUtil;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/teacher")
@CrossOrigin
@Slf4j
@ApiModel(value = "Teacher", description = "")
public class TeacherController {

    @Autowired
    ITeacherService teacherServiceImpl;

    @PostMapping("/save")
    public R save(@RequestBody TeacherVo teacherVo){

        Teacher teacherPo = new Teacher();
        BeanUtils.copyProperties(teacherVo,teacherPo);
        // fill token
        teacherPo.setToken(JwtUtil.sign(teacherPo.getUsername(),teacherPo.getPassword()));
        // password by Md5 encryption
        teacherPo.setPassword(DigestUtils.md5DigestAsHex(teacherPo.getPassword().getBytes()));
        boolean result = teacherServiceImpl.save(teacherPo);

        return result?R.ok().build():R.fail().message("保存失败").build();
    }

    @GetMapping("/list")
    public R list(){
        List<Teacher> list = teacherServiceImpl.list();
        return R.ok().data(list).build();
    }

    @GetMapping("/list/{page}/{limit}")
    public R listForPage(@PathVariable int page,
                         @PathVariable int limit){

        IPage<Teacher> iPage = new Page<>(page,limit);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("gmt_create");
        List<Teacher> teacherList = teacherServiceImpl.page(iPage,wrapper).getRecords();
        // teacherList -> teacherVoList
        List<TeacherVo> teacherVoList = teacherList.stream().map(teacher -> {
            TeacherVo teacherVo = TeacherVo.builder().build();
            BeanUtils.copyProperties(teacher, teacherVo);
            return teacherVo;
        }).collect(Collectors.toList());

        Map map = new HashMap<>();
        map.put("teacherList",teacherVoList);
        map.put("total", iPage.getTotal());
        return R.ok().data(map).build();
    }

    @DeleteMapping("/crud/{id}")
    public R remove(@PathVariable Integer id){
        log.info("remove-id-{}",id);
        boolean result = teacherServiceImpl.removeById(id);
        return result?R.ok().build():R.fail().message("删除失败").build();
    }

    @GetMapping("/crud/{id}")
    public R getOne(@PathVariable Integer id){
        log.info("getOne-id-{}",id);
        Teacher teacherPo = teacherServiceImpl.getById(id);
        TeacherVo teacherVo = TeacherVo.builder().build();
        BeanUtils.copyProperties(teacherPo,teacherVo);
        return R.ok().data(teacherVo).build();
    }

    @PutMapping("/crud")
    public R update(@RequestBody TeacherVo teacherVo){
        log.info("{}",teacherVo);
        Teacher teacherPo = new Teacher();
        BeanUtils.copyProperties(teacherVo,teacherPo);
        // fill token
        teacherPo.setToken(JwtUtil.sign(teacherPo.getUsername(),teacherPo.getPassword()));
        // password by Md5 encryption
        teacherPo.setPassword(DigestUtils.md5DigestAsHex(teacherPo.getPassword().getBytes()));
        boolean result = teacherServiceImpl.updateById(teacherPo);
        return result?R.ok().build():R.fail().message("更新失败").build();

    }



}
