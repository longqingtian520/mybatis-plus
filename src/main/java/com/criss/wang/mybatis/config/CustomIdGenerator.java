package com.criss.wang.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 * @Author wangqiubao
 * @Date 2020/1/20 16:17
 * @Version 1.0
 * @Description  自定义ID生成器
 **/
@Slf4j
@Component
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Long nextId(Object entity) {
        final long id = System.currentTimeMillis();
        log.info("为生成主键值->:{}", id);
        return id;
    }

}
