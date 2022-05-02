package cn.zyc.wc.service.impl;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.mapper.TeacherMapper;
import cn.zyc.wc.service.ITeacherService;
import cn.zyc.wc.util.JwtUtil;
import cn.zyc.wc.util.ZycTools;
import cn.zyc.wc.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyc
 * @since 2022-04-17
 */
@Service
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * login logic
     * @param userVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String login(UserVo userVo) throws WisdomException, JsonProcessingException {
        /**
         * 1. 根据用户名，密码（Md5）查询用户是否存在
         *      1.1 不存在，抛出异常，结束。
         * 2. 存在，使用JWT生成token保存到数据库，并保存到redis中（key：token，value：权限集合）
         * 3. 返回token。
         */
        // get token
        String token = JwtUtil.sign(userVo.getUsername(), userVo.getPassword());
        // password by Md5 encryption
        userVo.setPassword(DigestUtils.md5DigestAsHex(userVo.getPassword().getBytes()));
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Teacher::getUsername,userVo.getUsername())
                .eq(Teacher::getPassword, userVo.getPassword());
        Teacher teacher = baseMapper.selectOne(wrapper);
        if(teacher == null){
            throw new WisdomException("帐号或密码出错！");
        }
        // update token
        teacher.setToken(token);
        int updateResult = baseMapper.updateById(teacher);
        if(updateResult == 0){
            throw new WisdomException("后台保存token失败");
        }
        // token store to redis
        // 查询用户的角色，保存到redis，之后用于过滤器拦截请求
//        List<Integer> roles = Stream.of(teacher.getRole()).collect(Collectors.toList());
//        String rolesInfo = objectMapper.writeValueAsString(roles);
//        stringRedisTemplate.opsForValue().set(token,rolesInfo,30 *  60, TimeUnit.SECONDS);

        return teacher.getToken();
    }
}
