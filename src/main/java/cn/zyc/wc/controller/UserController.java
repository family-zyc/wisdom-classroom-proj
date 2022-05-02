package cn.zyc.wc.controller;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.R;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.service.ITeacherService;
import cn.zyc.wc.util.JwtUtil;
import cn.zyc.wc.vo.UserVo;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public R login(@RequestBody UserVo userVo) throws WisdomException, JsonProcessingException {
        log.info("...{}",userVo);

        String token = teacherServiceImpl.login(userVo);

        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return R.<Map>ok().data(map).build();
    }

    @GetMapping("/info")
    public R info(String token) throws WisdomException {
        log.info("...{}",token);
        /**
         * 1. 判断token是否过期，如果过期，返回50014错误码
         * 2. 判断token是否合法，如果不合法，返回50008错误码
         * 3. 如果没过期，根据token查询用户，返回对应的数据
         *
         */
        if(JwtUtil.isJwtExpired(token)){
            return R.fail().code(50014).build();
        }
        if(!JwtUtil.verify(token)){
            return R.fail().code(50008).build();
        }

        Teacher teacher = teacherServiceImpl.lambdaQuery().eq(Teacher::getToken, token).one();
        if(teacher == null){
            throw new WisdomException("token不存在！");
        }

        HashMap<String,Object> map = new HashMap<>();
        map.put("id",teacher.getId());
        map.put("name",teacher.getUsername());
        map.put("avatar",teacher.getAvatar());
        map.put("role",teacher.getRole());
        return R.<Map>ok().data(map).build();
    }

    @PostMapping("/logout")
    public R logout(){
        return R.ok().build();
    }

}
