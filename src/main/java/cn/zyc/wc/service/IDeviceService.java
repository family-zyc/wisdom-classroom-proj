package cn.zyc.wc.service;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Device;
import cn.zyc.wc.vo.DeviceQueryVo;
import cn.zyc.wc.vo.DeviceVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyc
 * @since 2022-04-23
 */
public interface IDeviceService extends IService<Device> {

    boolean saveDevice(Device device) throws WisdomException;

    List<DeviceVo> listForCondition(DeviceQueryVo deviceQuery);

    boolean removeByDeviceId(String deviceId) throws WisdomException;
}
