package cn.zyc.wc.mapper;

import cn.zyc.wc.po.DeviceFault;
import cn.zyc.wc.vo.DeviceFaultVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyc
 * @since 2022-04-23
 */
public interface DeviceFaultMapper extends BaseMapper<DeviceFault> {

    List<DeviceFaultVo> selectByCondition(DeviceFaultVo deviceFaultQuery);
}
