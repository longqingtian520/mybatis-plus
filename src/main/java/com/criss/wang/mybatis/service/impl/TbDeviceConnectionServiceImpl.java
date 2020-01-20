package com.criss.wang.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.criss.wang.mybatis.entity.TbDeviceConnection;
import com.criss.wang.mybatis.mapper.TbDeviceConnectionMapper;
import com.criss.wang.mybatis.service.ITbDeviceConnectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-19
 */
@Service
@DS("slave")
public class TbDeviceConnectionServiceImpl extends ServiceImpl<TbDeviceConnectionMapper, TbDeviceConnection> implements ITbDeviceConnectionService {

}
