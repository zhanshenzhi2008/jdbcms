package com.orjrs.jdbcms.model;

import lombok.Data;

/**
 * Girl
 *
 * @author orjrs
 * @date 2019-04-14 16:59
 */
@Data
public class Girl {
    /** 主键 */
    private Long id;

    /** 姓名 */
    private String name;

    /** 性别 */
    private Integer sex;

    /** 地址 */
    private String address;

    /** 杯罩 */
    private String cupSize;

    /** 杯罩 */
    private int age;

}