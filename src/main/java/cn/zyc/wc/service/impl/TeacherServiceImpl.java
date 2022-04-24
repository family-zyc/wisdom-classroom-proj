package cn.zyc.wc.service.impl;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.mapper.TeacherMapper;
import cn.zyc.wc.service.ITeacherService;
import cn.zyc.wc.util.ZycTools;
import cn.zyc.wc.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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

    /**
     * login logic
     * @param userVo
     * @return
     */
    @Override
    public String login(UserVo userVo) throws WisdomException {
        // password by Md5 encryption
        userVo.setPassword(DigestUtils.md5DigestAsHex(userVo.getPassword().getBytes()));
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        try {
            wrapper.allEq(ZycTools.convert(userVo));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Teacher teacher = baseMapper.selectOne(wrapper);

        if(teacher == null){
            throw new WisdomException("帐号或密码出错！");
        }
        return teacher.getToken();
    }
}
