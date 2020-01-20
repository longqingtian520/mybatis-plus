package com.criss.wang.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.criss.wang.mybatis.entity.TbFenceInfo;
import com.criss.wang.mybatis.mapper.TbFenceInfoMapper;
import com.criss.wang.mybatis.service.ITbFenceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-20
 */
@Service
@DS("slave")
public class TbFenceInfoServiceImpl extends ServiceImpl<TbFenceInfoMapper, TbFenceInfo> implements ITbFenceInfoService {

}
