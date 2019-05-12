package com.orjrs.jdbcms.controller;

import com.orjrs.jdbcms.model.Girl;
import com.orjrs.jdbcms.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * GirlController
 *
 * @author orjrs
 * @date 2019-04-21 18:28
 */
@RestController
public class GirlController {
    @Autowired
    private GirlService girlService;

    /**
     * 查询 Girl信息
     *
     * @param id 主键
     * @return Girl
     */
    @PostMapping("/girl/queryGirl")
    public Girl queryGirl(Long id) {
        return girlService.queryGirl(id);
    }

    /**
     * 保存 Girl信息
     *
     * @param girl Girl信息
     * @return 1 成功 0失败
     */
    @PostMapping("/girl/saveGirl")
    public Integer saveGirl(@RequestBody Girl girl) {
        return girlService.saveGirl(girl);
    }
}
