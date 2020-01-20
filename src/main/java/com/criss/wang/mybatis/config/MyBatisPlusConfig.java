package com.criss.wang.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

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
//         paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
//        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
//        return new PaginationInterceptor();
    }

    /**
     * @description: SQL执行效率插件
     * @author: gradual
     * @date: 19-1-24 下午4:59
     * @param: []
     * @return: com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     */
    @Bean
    @Profile({"dev"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
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

    /**
     * 逻辑删除用，3.1.1之后的版本可不需要配置该bean，但项目这里用的是3.1.0的
     *
     * @author David Hong
     *
     * @return com.baomidou.mybatisplus.core.injector.ISqlInjector
     */
//    @Bean
//    public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }

}
