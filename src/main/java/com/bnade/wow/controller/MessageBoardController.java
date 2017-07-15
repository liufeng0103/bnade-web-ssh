package com.bnade.wow.controller;

import com.bnade.wow.entity.MessageBoard;
import com.bnade.wow.entity.WowToken;
import com.bnade.wow.repository.WowTokenRepository;
import com.bnade.wow.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 时光徽章
 * Created by liufeng0103@163.com on 2017/6/6.
 */
@RestController
@RequestMapping("/messages")
public class MessageBoardController {

    @Autowired
    private MessageBoardService messageBoardService;

    /**
     * 保存留言
     * @param messageBoard 留言
     * @return 创建的留言信息
     */
    @PostMapping
    public MessageBoard save(@Valid MessageBoard messageBoard) {
        return messageBoardService.save(messageBoard);
    }

}
