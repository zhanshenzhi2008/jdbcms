package com.orjrs.jdbcms.config;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liujun22
 * CreateDate:2019/3/10 19:24
 */
public class DBContextHolder {
    /** */
    private static ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    /** */
    private static AtomicInteger atomicInteger = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        //  轮询
        int index = atomicInteger.getAndIncrement() % 2;
        if (atomicInteger.get() > 9999) {
            atomicInteger.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            System.out.println("切换到slave1");
        } else {
            set(DBTypeEnum.SLAVE2);
            System.out.println("切换到slave2");
        }
    }
}
