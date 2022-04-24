package cn.zyc.wc.controller;


import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Device;
import cn.zyc.wc.po.DeviceFault;
import cn.zyc.wc.po.R;
import cn.zyc.wc.service.IDeviceFaultService;
import cn.zyc.wc.vo.DeviceFaultVo;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2022-04-23
 */
@RequestMapping("/device-fault")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "Device-Fault", description = "")
public class DeviceFaultController {

    @Autowired
    IDeviceFaultService deviceFaultServiceImpl;

    @PostMapping("/crud")
    public R save(@RequestBody DeviceFault deviceFault) throws WisdomException {
        log.info("save()--{}",deviceFault);
        boolean result = deviceFaultServiceImpl.applyDeviceFault(deviceFault);
        return result? R.ok().build():R.fail().message("申请失败").build();
    }

    @GetMapping("/crud/{currentPage}/{limit}")
    public R listForConditionPage(@PathVariable int currentPage,
                                  @PathVariable int limit,
                                  DeviceFaultVo deviceFaultQuery){
        log.info("listForConditionPage()--{}",deviceFaultQuery);
        Page<DeviceFaultVo> pageHelp = PageHelper.<DeviceFaultVo>startPage(currentPage, limit);
        List<DeviceFaultVo> list = deviceFaultServiceImpl.listForCondition(deviceFaultQuery);
        Map map = new HashMap<>();
        map.put("deviceFaultList",pageHelp.getResult());
        map.put("total",pageHelp.getTotal());
        return R.ok().data(map).build();
    }

    @PutMapping("/crud/{id}/{handleState}")
    public R updateHandleState(@PathVariable int id,
                               @PathVariable int handleState) throws WisdomException {

        boolean result = deviceFaultServiceImpl.handlerState(id,handleState);

        return result? R.ok().build():R.fail().message("更新失败").build();
    }

}
