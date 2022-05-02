package cn.zyc.wc.service;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.vo.UserVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyc
 * @since 2022-04-17
 */
public interface ITeacherService extends IService<Teacher> {

    String login(UserVo userVo) throws WisdomException, JsonProcessingException;
}
