package cn.zyc.wc;

import cn.zyc.wc.controller.SchoolScheduleWeekController;
import cn.zyc.wc.mapper.DeviceMapper;
import cn.zyc.wc.po.Device;
import cn.zyc.wc.po.SchoolScheduleWeek;
import cn.zyc.wc.po.Teacher;
import cn.zyc.wc.service.IDeviceService;
import cn.zyc.wc.service.ITeacherService;
import cn.zyc.wc.service.impl.TeacherServiceImpl;
import cn.zyc.wc.util.JwtUtil;
import cn.zyc.wc.util.ZycTools;
import cn.zyc.wc.vo.UserVo;
import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

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
@Slf4j
class MainTest {

    @Autowired
    private ITeacherService teacherServiceImpl;

    @Autowired
    private SchoolScheduleWeekController schoolScheduleWeekController;
    @Autowired
    IDeviceService deviceServiceImpl;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void contextLoads() throws Exception {

        String url = "http://api.nlecloud.com/Devices/Datas";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
//        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
        if(httpResponse.getStatusLine().getStatusCode() == 200){
            HttpEntity entity = httpResponse.getEntity();
            log.info("contextLoads()--entity--{}",entity);
            String result = EntityUtils.toString(entity);
            log.info("contextLoads()--result--{}",result);

        }else{
            log.info("contextLoads()--{}","出错了");
        }

    }






}
