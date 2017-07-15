package com.bnade.wow.repository;

import com.bnade.wow.entity.Auction;
import com.bnade.wow.entity.MessageBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by liufeng0103@163.com on 2017/6/12.
 */
public interface MessageBoardRepository extends JpaRepository<MessageBoard, Integer> {

}
