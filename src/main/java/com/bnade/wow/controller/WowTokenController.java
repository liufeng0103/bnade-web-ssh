package com.bnade.wow.controller;

import com.bnade.wow.entity.WowToken;
import com.bnade.wow.repository.WowTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 时光徽章
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@RestController
@RequestMapping("/wowtokens")
public class WowTokenController {

    @Autowired
    private WowTokenRepository wowTokenRepository;

    @RequestMapping
    public List<WowToken> findAll() {
        return wowTokenRepository.findAll();
    }
}
