package com.bnade.wow.repository;

import com.bnade.wow.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 宠物信息的数据库操作
 * Created by liufeng0103@163.com on 2017/6/27.
 */
public interface PetRepository extends JpaRepository<Pet, Integer> {

}
