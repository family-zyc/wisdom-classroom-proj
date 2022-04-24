package cn.zyc.wc.service;

import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.DeviceFault;
import cn.zyc.wc.vo.DeviceFaultVo;
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
public interface IDeviceFaultService extends IService<DeviceFault> {

    List<DeviceFaultVo> listForCondition(DeviceFaultVo deviceFaultQuery);

    boolean handlerState(int id, int handleState) throws WisdomException;

    boolean applyDeviceFault(DeviceFault deviceFault) throws WisdomException;
}
