package com.bnade.wow.controller;

import com.bnade.wow.entity.Wowtoken;
import com.bnade.wow.repository.WowtokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 时光徽章
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@RestController
@RequestMapping("/wowtokens")
public class WowtokenController {

    @Autowired
    private WowtokenRepository wowtokenRepository;

    /**
     * 获取所有的时光徽章历史记录
     * @return 时光徽章列表
     */
    @RequestMapping
    public List<Wowtoken> findAll() {
        return wowtokenRepository.findAll();
    }
}
