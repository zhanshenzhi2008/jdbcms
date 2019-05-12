package com.orjrs.jdbcms.service;

import com.orjrs.jdbcms.annotation.Master;
import com.orjrs.jdbcms.annotation.Slaver;
import com.orjrs.jdbcms.mapper.GirlMapper;
import com.orjrs.jdbcms.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GirlService
 *
 * @author orjrs
 * @date 2019-04-22 21:25
 */
@Service
public class GirlService {

    private final GirlMapper girlMapper;

    @Autowired
    public GirlService(GirlMapper girlMapper) {
        this.girlMapper = girlMapper;
    }

    /**
     * 查询 Girl信息
     *
     * @param id 主键
     * @return Girl
     */
    public Girl queryGirl(Long id) {
        return girlMapper.getGirlById(id);
    }

    /**
     * 保存 Girl信息
     *
     * @param girl Girl信息
     * @return 1 成功 0失败
     */
    public Integer saveGirl(Girl girl) {
        return girlMapper.saveGirl(girl);
    }
}
