package cn.zyc.wc.controller;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.R;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.service.ITeacherService;
import cn.zyc.wc.vo.UserVo;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyc
 * @date 2022/4/17
 */
@RestController
@RequestMapping("/user")
@ApiModel(value = "User", description = "")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    ITeacherService teacherServiceImpl;

    @PostMapping("/login")
    public R login(@RequestBody UserVo userVo) throws WisdomException {
        log.info("...{}",userVo);
        String token = teacherServiceImpl.login(userVo);

        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return R.<Map>ok().data(map).build();
    }

    @GetMapping("/info")
    public R info(String token) throws WisdomException {
        log.info("...{}",token);

        Teacher teacher = teacherServiceImpl.lambdaQuery().eq(Teacher::getToken, token).one();
        if(teacher == null){
            throw new WisdomException("token不存在！");
        }

        HashMap<String,Object> map = new HashMap<>();
        map.put("id",teacher.getId());
        map.put("name",teacher.getUsername());
        map.put("avatar",teacher.getAvatar());
        return R.<Map>ok().data(map).build();
    }

    @PostMapping("/logout")
    public R logout(){
        return R.ok().build();
    }

}
