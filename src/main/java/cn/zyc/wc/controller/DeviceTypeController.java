package cn.zyc.wc.controller;


import cn.zyc.wc.po.DeviceType;
import cn.zyc.wc.po.R;
import cn.zyc.wc.service.IDeviceTypeService;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2022-04-25
 */
@RequestMapping("/device-type")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "Device-Type", description = "")
public class DeviceTypeController {

    @Autowired
    IDeviceTypeService deviceTypeServiceImpl;

    @GetMapping("/crud")
    public R list(){
        List<DeviceType> list = deviceTypeServiceImpl.list();
        return R.ok().data(list).build();
    }

}
