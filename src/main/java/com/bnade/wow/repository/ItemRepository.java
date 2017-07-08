package com.bnade.wow.repository;

import com.bnade.wow.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 物品信息的数据库操作
 * Created by liufeng0103@163.com on 2017/6/27.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

    /**
     * 查询含有name的所有物品
     * 使用原生SQL查询结果，这里用到了MySQL全文检索的查询方式
     * @param name 查询名
     * @return 物品列表
     */
    @Query(value = "SELECT * FROM item WHERE MATCH (name) AGAINST (?1 IN BOOLEAN MODE)", nativeQuery = true)
    List<Item> searchByName(String name);

    /**
     * 查询所有包含查询值的物品名
     * 使用原生SQL查询结果，这里用到了MySQL全文检索的查询方式
     * @param name 查询名
     * @param limit 返回条数
     * @return 物品名列表
     */
    @Query(value = "SELECT name FROM item WHERE MATCH (name) AGAINST (?1 IN BOOLEAN MODE) ORDER BY hot DESC LIMIT 0,?2", nativeQuery = true)
    List<String> searchNamesByNameContaining(String name, Integer limit);

    /**
     * 通过物品名查询物品
     * @param name 物品名
     * @return 物品列表
     */
    List<Item> findByName(String name);

}
