package com.bnade.wow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnade.wow.entity.Pet;

/**
 * 宠物信息的数据库操作
 * Created by liufeng0103@163.com on 2017/6/27.
 */
public interface PetRepository extends JpaRepository<Pet, Integer> {

	List<Pet> findByName(String name);
}
