package cn.zyc.wc.controller;


import cn.zyc.wc.po.Device;
import cn.zyc.wc.po.R;
import cn.zyc.wc.service.IDeviceService;
import cn.zyc.wc.util.ZycTools;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.sql.Driver;
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
@RequestMapping("/device")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "Device", description = "")
public class DeviceController {

    @Autowired
    IDeviceService deviceServiceImpl;

    @GetMapping("/crud/{classroomId}")
    public R listForClassroomId(@PathVariable int classroomId) throws Exception {
        QueryWrapper<Device> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Device::getClassroomId,classroomId);
        List<Device> list = deviceServiceImpl.list(wrapper);
        return R.ok().data(list).build();
    }

}
