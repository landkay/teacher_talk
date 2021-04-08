package com.landkay.springboot.schedule;

import com.landkay.springboot.utils.HttpUtils;
import com.landkay.springboot.utils.SSLClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 90818
 */
@Slf4j
@Configuration
@EnableScheduling
public class BaiDuScheduled {

    private final static Logger log = LoggerFactory.getLogger(BaiDuScheduled.class);

    /**
     * Description // 秒、分、时、日、月、年
     * @param
     * @Author landkay
     * @Date 10:38 2018/8/2
     * @return 
     **/
    @Scheduled(cron = "0/10 * * * * ?")
    public void pushDataScheduled() {

        String url = "https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9590297299213189222%22%7D&n_type=1&p_from=3";
        Map<String, Object> paramsMap = new HashMap(8);
        try {
            //往服务端写数据
            String outStr = null;
            String get = SSLClient.httpsRequest(url, "GET", outStr);

            //StringBuffer stringBuffer = HttpUtils.URLGet(url, paramsMap);
            //log.info("访问百家号响应参数: " + stringBuffer.toString());
            log.info("访问百家号响应参数: " + get);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}