package com.bnade.wow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 数据统计服务
 * Created by liufeng0103@163.com on 2017/7/11.
 */
@Service
public class StatisticService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 记录某个ip查询的物品id, 用于统计物品搜索情况
     * 把IP和itemId保存到redis的set中， 格式 k = ipxxx.xxx.xxx.xxx, v = 12345
     * @param ip IP
     * @param itemId 物品id
     */
    public void recordItemSearchedByIp(String ip, String itemId) {
        stringRedisTemplate.opsForSet().add("ip" + ip, itemId);
    }

}
