package com.bnade.wow.repository;

import com.bnade.wow.entity.ItemBonus;
import com.bnade.wow.entity.ItemBonusPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 物品奖励信息的数据库操作
 * Created by liufeng0103@163.com on 2017/6/27.
 */
public interface ItemBonusRepository extends JpaRepository<ItemBonus, ItemBonusPK> {

    /**
     * 查询物品所有的bonus list
     * @param itemId 物品ID
     * @return bonus组合列表
     */
    @Query(value = "SELECT ib.bonusList FROM ItemBonus ib WHERE ib.itemId=?1")
    List<String> findBonusListByItemId(Integer itemId);

}
