package com.orjrs.jdbcms.config;

import com.orjrs.jdbcms.annotation.Slaver;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liujun22
 * CreateDate:2019/3/10 19:24
 */

@Aspect
@Component
@Slf4j
public class DataSourceAop {
    @Pointcut(value = "!@annotation(com.orjrs.jdbcms.annotation.Master) " +
            "&& (execution(* com.orjrs.jdbcms.service.*.select*(..)) " +
            "|| execution(* com.orjrs.jdbcms.service.*.get*(..))" +
            "|| execution(* com.orjrs.jdbcms.service.*.query*(..)))")
    public void readPointcut() {

    }

    @Pointcut(value = "!@annotation(com.orjrs.jdbcms.annotation.Slaver) " +
            "&& (execution(* com.orjrs.jdbcms.service.*.insert*(..)) " +
            "|| execution(* com.orjrs.jdbcms.service.*.update*(..))" +
            "|| execution(* com.orjrs.jdbcms.service.*.disabled*(..))" +
            "|| execution(* com.orjrs.jdbcms.service.*.save*(..))" +
            "|| execution(* com.orjrs.jdbcms.service.*.delete*(..)))")
    public void writePointcut() {
    }

    @Before("readPointcut()")
    public void read() {
        log.info("dataSource切换Slaver库");
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        log.info("dataSource切换到Master库");
        DBContextHolder.master();
    }

    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
