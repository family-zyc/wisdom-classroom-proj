package cn.zyc.wc;

import cn.zyc.wc.controller.SchoolScheduleWeekController;
import cn.zyc.wc.mapper.DeviceMapper;
import cn.zyc.wc.po.Device;
import cn.zyc.wc.po.SchoolScheduleWeek;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.service.IDeviceService;
import cn.zyc.wc.service.ITeacherService;
import cn.zyc.wc.util.JwtUtil;
import cn.zyc.wc.util.ZycTools;
import cn.zyc.wc.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zyc
 * @date 2022/4/17
 */
@SpringBootTest
class MainTest {

    @Autowired
    private ITeacherService teacherServiceImpl;

    @Autowired
    private SchoolScheduleWeekController schoolScheduleWeekController;
    @Autowired
    IDeviceService deviceServiceImpl;
    @Autowired
    DeviceMapper deviceMapper;

    @Test
    void contextLoads() throws Exception {
        UpdateWrapper<Device> deviceWrapper = new UpdateWrapper<>();
        deviceWrapper.lambda().eq(Device::getDeviceId,"TGG").set(Device::getIsDisable,false);
        boolean result = deviceServiceImpl.update(deviceWrapper);
        System.out.println(result);

    }






}
