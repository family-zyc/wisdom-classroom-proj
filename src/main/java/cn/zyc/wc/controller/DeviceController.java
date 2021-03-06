package cn.zyc.wc.controller;


import cn.zyc.wc.exception.WisdomException;
import cn.zyc.wc.po.Device;
import cn.zyc.wc.po.R;
import cn.zyc.wc.service.IDeviceService;
import cn.zyc.wc.util.ZycTools;
import cn.zyc.wc.vo.DeviceQueryVo;
import cn.zyc.wc.vo.DeviceVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
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


    @GetMapping("/crud/{currentPage}/{limit}")
    public R listForConditionPage(@PathVariable int currentPage,
                                  @PathVariable int limit,
                                  DeviceQueryVo deviceQuery){
        log.info("listForConditionPage--{}",deviceQuery);
        Page<DeviceVo> pageHelp = PageHelper.startPage(currentPage, limit);
        List<DeviceVo> list = deviceServiceImpl.listForCondition(deviceQuery);
        Map map = new HashMap();
        map.put("deviceVoList",pageHelp.getResult());
        map.put("total",pageHelp.getTotal());
        return R.ok().data(map).build();
    }


    @PostMapping("/crud")
    public R save(@RequestBody Device device) throws WisdomException {


        boolean result = deviceServiceImpl.saveDevice(device);
        return result?R.ok().build():R.fail().message("保存失败").build();
    }

    @DeleteMapping("/crud/{deviceId}")
    public R removeByDeviceId(@PathVariable String deviceId) throws WisdomException {
        boolean result = deviceServiceImpl.removeByDeviceId(deviceId);
        return result? R.ok().build():R.fail().message("删除失败").build();
    }

    @GetMapping("/test/httpClient")
    public void test () throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8888/device/crud/1/10");
        CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
        if(httpResponse.getStatusLine().getStatusCode() == 200){
            HttpEntity entity = httpResponse.getEntity();
            log.info("test()--entity--{}",entity);
            String result = EntityUtils.toString(entity);
            log.info("test()--result--{}",result);

        }else{
            log.info("test()--{}","出错了");
        }

    }


}
