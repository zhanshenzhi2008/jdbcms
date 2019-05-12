package com.orjrs.jdbcms.mapper;

import com.orjrs.jdbcms.model.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * GirlMapper
 *
 * @author orjrs
 * @date 2019-04-14 16:55
 */
@Repository
@Mapper
public interface GirlMapper {

    /**
     * 查询 Girl信息
     *
     * @param id 主键
     * @return Girl
     */
    Girl getGirlById(Long id);

    /**
     * 保存 Girl信息
     *
     * @param girl Girl信息
     * @return 1 成功 0失败
     */
    Integer saveGirl(Girl girl);
}
