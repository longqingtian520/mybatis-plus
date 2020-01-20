package com.criss.wang.mybatis.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author wangqiubao
 * @Date 2020/1/15 11:34
 * @Version 1.0
 * @Description
 **/
@Configuration
public class MyBatisPlusConfig {

    private final static Logger logger = LoggerFactory.getLogger(MyBatisPlusConfig.class);

    /**
     * @description: 配置分页插件
     * @author: gradual
     * @date: 2019/1/15 10:17
     * @param: []
     * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        logger.debug("注册分页插件");
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
         paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /*
     * 乐观锁配置
     * @Author wangqiubao
     * @Date 2020/1/19 16:00
     * @Param []
     * @return com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
     * @Description
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /*
     * @Author wangqiubao
     * @Date 2020/1/20 16:30
     * @Param []
     * @return com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator
     * @Description 自定义ID生成器
     */
    @Bean
    public IdentifierGenerator idGenerator() {
        return new CustomIdGenerator();
    }

}
