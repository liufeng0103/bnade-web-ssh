package com.bnade.wow.service;

import com.bnade.wow.entity.MessageBoard;
import com.bnade.wow.repository.MessageBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 留言板服务
 * Created by liufeng0103@163.com on 2017/7/11.
 */
@Service
public class MessageBoardService {

    @Autowired
    private MessageBoardRepository messageBoardRepository;

    public MessageBoard save(MessageBoard messageBoard) {
        return messageBoardRepository.save(messageBoard);
    }

}
