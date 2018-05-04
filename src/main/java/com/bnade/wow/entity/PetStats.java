package com.bnade.wow.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * 宠物信息 Created by liufeng0103@163.com on 2017/6/27.
 */
@Entity
@IdClass(PetStatsPK.class)
public class PetStats implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer speciesId;
	@Id
	private Integer breedId;
	private Integer petQualityId;
	private Integer level;
	private Integer health;
	private Integer power;
	private Integer speed;

	public Integer getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	public Integer getBreedId() {
		return breedId;
	}

	public void setBreedId(Integer breedId) {
		this.breedId = breedId;
	}

	public Integer getPetQualityId() {
		return petQualityId;
	}

	public void setPetQualityId(Integer petQualityId) {
		this.petQualityId = petQualityId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "PetStats [speciesId=" + speciesId + ", breedId=" + breedId + ", petQualityId=" + petQualityId
				+ ", level=" + level + ", health=" + health + ", power=" + power + ", speed=" + speed + "]";
	}

}
