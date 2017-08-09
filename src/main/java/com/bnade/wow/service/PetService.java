package com.bnade.wow.service;

import com.bnade.wow.entity.Pet;
import com.bnade.wow.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 物品service
 * Created by liufeng0103@163.com on 2017/6/12.
 */
@Service
public class PetService {

    private static Logger logger = LoggerFactory.getLogger(PetService.class);

    @Autowired
    private PetRepository petRepository;

    /**
     * 通过id查询宠物信息
     *
     * @param petId 宠物id，在拍卖数据中叫petSpeciesId
     * @return Pet 宠物信息
     */
    @Cacheable(cacheNames="pets", keyGenerator="customKeyGenerator")
    public Pet findById(Integer petId) {
        return petRepository.findOne(petId);
    }

}
