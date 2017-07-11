package com.bnade.wow.aspect;

import com.bnade.wow.entity.CheapestAuction;
import com.bnade.wow.service.StatisticService;
import com.bnade.wow.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 切面，用于统计
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@Aspect
@Component
public class StatisticAspect {

    private final static Logger logger = LoggerFactory.getLogger(StatisticAspect.class);

    @Autowired
    private StatisticService statisticService;

    /**
     * 查询物品最低价时统计物品查询
     * @param point 切点
     * @return 切面方法返回值
     * @throws Throwable 异常
     */
    @Around("execution(public * com.bnade.wow.controller.CheapestAuctionController.findAll(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        // 获取方法参数
        CheapestAuction cheapestAuction = null;
        Object[] args = point.getArgs();
        if (args != null && args.length == 1) {
            cheapestAuction = (CheapestAuction)args[0];
        }
        // 实际方法运行
        Object returnValue = point.proceed();
        if (cheapestAuction != null && returnValue != null && returnValue instanceof List) {
            // 当有返回数据时才统计
            if (((List) returnValue).size() > 0) {
                // 获取httprequest
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                String ip = IPUtils.getIp(request);
                // 统计物品搜索
                logger.debug("记录ip: {}, item: {}", ip, cheapestAuction.getItemId());
                statisticService.recordItemSearchedByIp(ip, "" + cheapestAuction.getItemId());
            }
        }
        return returnValue;
    }


}
