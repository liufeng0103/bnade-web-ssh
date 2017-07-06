package com.bnade.wow.service;

import com.bnade.wow.entity.Realm;
import com.bnade.wow.repository.RealmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务器信息
 * Created by liufeng0103@163.com on 2017/7/6.
 */
@Service
public class RealmService {

    @Autowired
    private RealmRepository realmRepository;

    /**
     * 查找所有服务器信息
     * @return List
     */
    public List<Realm> findAll() {
        return realmRepository.findAll();
    }
}
