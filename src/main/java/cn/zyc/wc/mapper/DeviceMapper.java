package cn.zyc.wc.mapper;

import cn.zyc.wc.po.Device;
import cn.zyc.wc.vo.DeviceQueryVo;
import cn.zyc.wc.vo.DeviceVo;
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
public interface DeviceMapper extends BaseMapper<Device> {

    List<DeviceVo> selectForCondition(DeviceQueryVo deviceQuery);
}
