package com.bnade.wow.repository;

import com.bnade.wow.entity.Realm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 魔兽服务器信息
 * Created by liufeng0103@163.com on 2017/7/6.
 */
public interface RealmRepository extends JpaRepository<Realm, Integer> {
}
