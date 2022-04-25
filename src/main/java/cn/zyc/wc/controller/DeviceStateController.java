package cn.zyc.wc.controller;


import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyc
 * @since 2022-04-25
 */
@RequestMapping("/device-state")
@RestController
@CrossOrigin
@Slf4j
@ApiModel(value = "Device-State", description = "")
public class DeviceStateController {

}
