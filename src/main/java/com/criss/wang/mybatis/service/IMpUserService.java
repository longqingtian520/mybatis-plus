package com.criss.wang.mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.criss.wang.mybatis.entity.MpUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-16
 */
public interface IMpUserService extends IService<MpUser> {

    IPage<MpUser> selectUserPage(Page<MpUser> page, Integer state);

    List<MpUser> selectUser();
}
