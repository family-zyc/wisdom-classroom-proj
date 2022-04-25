package cn.zyc.wc.service.impl;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Device;
import cn.zyc.wc.mapper.DeviceMapper;
import cn.zyc.wc.po.DeviceState;
import cn.zyc.wc.service.IDeviceService;
import cn.zyc.wc.service.IDeviceStateService;
import cn.zyc.wc.vo.DeviceQueryVo;
import cn.zyc.wc.vo.DeviceVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyc
 * @since 2022-04-23
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Autowired
    IDeviceStateService deviceStateServiceImpl;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean saveDevice(Device device) throws WisdomException {
        // 保存device和设备状态
        int deviceInsert = baseMapper.insert(device);
        DeviceState deviceState = new DeviceState();
        deviceState.setDeviceId(device.getDeviceId());
        boolean deviceStateInsert = deviceStateServiceImpl.save(deviceState);
        if(deviceInsert > 0 && deviceStateInsert){
            return true;
        }else{
            throw new WisdomException("保存失败");
        }
    }


    @Override
    public List<DeviceVo> listForCondition(DeviceQueryVo deviceQuery) {

        return baseMapper.selectForCondition(deviceQuery);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean removeByDeviceId(String deviceId) throws WisdomException {
        // 移除设备，设备状态
        int deleteDevice = baseMapper.delete(new QueryWrapper<Device>().lambda().eq(Device::getDeviceId, deviceId));
        boolean removeDeviceState = deviceStateServiceImpl.remove(new QueryWrapper<DeviceState>().lambda().eq(DeviceState::getDeviceId, deviceId));

        if(deleteDevice > 0 && removeDeviceState){
            return true;
        }else{
            throw new WisdomException("删除失败");
        }
    }
}
