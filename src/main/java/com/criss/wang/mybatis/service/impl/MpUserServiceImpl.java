package com.criss.wang.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.criss.wang.mybatis.entity.MpUser;
import com.criss.wang.mybatis.mapper.MpUserMapper;
import com.criss.wang.mybatis.service.IMpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-16
 */
@Service
@DS("master")
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements IMpUserService {

    @Autowired
    private MpUserMapper userMapper;

    @Override
    public IPage<MpUser> selectUserPage(Page<MpUser> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userMapper.selectPageVo(page, state);
    }

    @Override
    public List<MpUser> selectUser(){
        return userMapper.selectUser();
    }


}
