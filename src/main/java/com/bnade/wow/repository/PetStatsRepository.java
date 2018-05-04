package com.bnade.wow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnade.wow.entity.PetStats;

/**
 * 宠物信息的数据库操作 Created by liufeng0103@163.com on 2017/6/27.
 */
public interface PetStatsRepository extends JpaRepository<PetStats, Integer> {

	List<PetStats> findBySpeciesId(Integer speciesId);
}
