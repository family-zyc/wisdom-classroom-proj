package cn.zyc.wc.service.impl;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Device;
import cn.zyc.wc.po.DeviceFault;
import cn.zyc.wc.mapper.DeviceFaultMapper;
import cn.zyc.wc.service.IDeviceFaultService;
import cn.zyc.wc.service.IDeviceService;
import cn.zyc.wc.vo.DeviceFaultVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyc
 * @since 2022-04-23
 */
@Service

public class DeviceFaultServiceImpl extends ServiceImpl<DeviceFaultMapper, DeviceFault> implements IDeviceFaultService {

    @Autowired
    IDeviceService deviceServiceImpl;

    @Override
    public List<DeviceFaultVo> listForCondition(DeviceFaultVo deviceFaultQuery) {
        return baseMapper.selectByCondition(deviceFaultQuery);
    }

    @Override
    @Transactional
    public boolean handlerState(int id, int handleState) throws WisdomException {
        // 如果成功，顺便将该设备的状态改为可使用
        boolean deviceResult = true;
        if(handleState == 2){
            // 查询设备id
            DeviceFault deviceFault = this.getById(id);
            String deviceId = deviceFault.getDeviceId();
            // 修改设备的状态
            UpdateWrapper<Device> deviceWrapper = new UpdateWrapper<>();
            deviceWrapper.lambda().eq(Device::getDeviceId,deviceId).set(Device::getIsDisable,false);
            deviceResult = deviceServiceImpl.update(deviceWrapper);

        }
        UpdateWrapper<DeviceFault> deviceFaultWrapper = new UpdateWrapper<>();
        deviceFaultWrapper.lambda().eq(DeviceFault::getId,id).set(DeviceFault::getHandleState,handleState);
        boolean result = this.update(deviceFaultWrapper);


        if(deviceResult && result){
            return true;
        }else{
            throw new WisdomException("操作失败");
        }
    }

    @Override
    @Transactional
    public boolean applyDeviceFault(DeviceFault deviceFault) throws WisdomException {
        // Todo 1.判断有没有类似的报修,有则拒绝申请 2.将设备状态改为不可用
        // 判断有没有类似的报修,有则拒绝申请
        QueryWrapper<DeviceFault> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(DeviceFault::getClassroomId,deviceFault.getClassroomId())
                .eq(DeviceFault::getDeviceId,deviceFault.getDeviceId())
                .and(consumer -> consumer.eq(DeviceFault::getHandleState,0)
                        .or().eq(DeviceFault::getHandleState,1));
        Long count = baseMapper.selectCount(wrapper);
        if(count > 0){
            throw new WisdomException("该设备已报修");
        }
        // 将设备状态改为不可用
        UpdateWrapper<Device> deviceWrapper = new UpdateWrapper<>();
        deviceWrapper.lambda().eq(Device::getDeviceId,deviceFault.getDeviceId()).set(Device::getIsDisable,false);
        boolean deviceResult = deviceServiceImpl.update(deviceWrapper);
        // 添加报修信息
        int insert = baseMapper.insert(deviceFault);
        if(deviceResult && insert > 0){
            return true;
        }else{
            throw new WisdomException("申请失败");
        }
    }
}
