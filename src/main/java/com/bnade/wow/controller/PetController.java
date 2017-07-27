package com.bnade.wow.controller;

import com.bnade.wow.entity.Pet;
import com.bnade.wow.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 宠物信息相关
 *
 * Created by liufeng0103@163.com on 2017/7/27.
 */
@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    /**
     * 通过id查询宠物信息
     *
     * @param id 宠物id,在拍卖数据中叫petSpeciesId
     * @return Pet 宠物信息
     */
    @GetMapping("/{id}")
    public Pet findByid(@PathVariable("id") Integer id) {
        if (null == id) {
            return null;
        }
        return petService.findById(id);
    }

}
