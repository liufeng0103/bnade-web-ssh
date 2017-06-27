package com.bnade.wow.repository;

import com.bnade.wow.entity.ItemBonus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 物品奖励信息的数据库操作
 * Created by liufeng0103@163.com on 2017/6/27.
 */
public interface ItemBonusRepository extends JpaRepository<ItemBonus, Integer> {

    List<ItemBonus> findByItemId(int itemId);

}
