package com.bnade.wow.controller;

import com.bnade.wow.dto.AddonDataVersionDTO;
import com.bnade.wow.entity.Pet;
import com.bnade.wow.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 插件相关
 *
 * Created by liufeng0103@163.com on 2018/1/8.
 */
@RestController
@RequestMapping("/wow")
public class AddonController {

    @Value("${bnade.addon.data_version_file_path}")
    private String dataVersionPath;

    /**
     * 获取bnade插件数据版本
     * @return
     */
    @GetMapping("/addon/version")
    public AddonDataVersionDTO findDataVersion() {
        AddonDataVersionDTO addonDataVersionDTO = new AddonDataVersionDTO("");
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataVersionPath));
            if (lines.size() > 0) {
                addonDataVersionDTO.setVersion(lines.get(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addonDataVersionDTO;
    }

}
